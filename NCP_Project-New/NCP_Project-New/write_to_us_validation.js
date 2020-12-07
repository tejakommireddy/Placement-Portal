function printError(elemId, hintMsg) {
    document.getElementById(elemId).innerHTML = hintMsg;
}


function validateForm() {
   
    var name = document.getElementById('name').value;

    var mobile= document.getElementById('contactph').value;
    var email= document.getElementById('contactemail').value;

    var sub = document.getElementById('contactsub').value;
    var msg = document.getElementById('contactmsg').value;

    var nameErr = emailErr = mobileErr= subErr = msgErr=true;
    console.log(msg);
    
    // Validate name
    if(name == "") {
        printError("nameErr", "Please enter your name");
    } else {
        var regex = /^[a-zA-Z\s]+$/;                
        if(regex.test(name) === false) {
            printError("nameErr", "Please enter a valid name");
        } else {
            printError("nameErr", "");
            nameErr = false;
        }
    }
    
    // Validate email address
    if(email == "") {
        printError("emailErr", "Please enter your email address");
    } else {
        // Regular expression for basic email validation
        var regex = /^\S+@\S+\.\S+$/;
        if(regex.test(email) === false) {
            printError("emailErr", "Please enter a valid email address");
        } else{
            printError("emailErr", "");
            emailErr = false;
        }
    }
    
 
    if(mobile == "") {
        printError("mobileErr", "Please enter your mobile number");
    } else {
        var regex = /^[1-9]\d{9}$/;
        if(regex.test(mobile) === false) {
            printError("mobileErr", "Please enter a valid 10 digit mobile number");
        } else{
            printError("mobileErr", "");
            mobileErr = false;
        }
    }
    

    if(sub == "") {
        printError("subErr", "Please enter your subject");
    } else {
        var regex = /^[A-Za-z0-9_-]*$"/;                
        if(regex.test(sub) === false) {
            printError("subErr", "Please enter a valid subject");
        } else {
            printError("subErr", "");
            nameErr = false;
        }
    }

    if(msg == "") {
        printError("msgErr", "Please enter your subject");
    } else {
                    
        if(msg.split(/\r\n|\r|\n/).length <=1) {
            printError("msgErr", "Please enter a valid Message");
        } else {
            printError("msgErr", "");
            msgErr = false;
        }
    }
    
   
   

    if((nameErr || emailErr || mobileErr  || subErr || msgErr) == true) {
        return false;
     } 
};