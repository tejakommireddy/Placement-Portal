function printError(elemId, hintMsg) {
    document.getElementById(elemId).innerHTML = hintMsg;
}


function validateForm(event) {
   
    var name = document.getElementById('name').value;
    var mobile= document.getElementById('contactph').value;
    var email= document.getElementById('contactemail').value;
    var sub = document.getElementById('contactsub').value;
    var msg = document.getElementById('contactmsg').value;

    var nameErr = emailErr = mobileErr= subErr = msgErr=false;
    console.log(msg);
    
    // Validate name
    if(name == "") {
        printError("nameErr", "Please enter your name");
        nameErr=false;
        event.preventDefault();
    } else {
        var regex = /^[a-zA-Z\s]+$/;                
        if(regex.test(name) === false) {
            printError("nameErr", "Please enter a valid name");
            nameErr=true;
            event.preventDefault();
        } else {
            printError("nameErr", "");
        }
    }
    
    // Validate email address
    if(email == "") {
    	event.preventDefault();
        printError("emailErr", "Please enter your email address");
        emailErr=true;
    } else {
        // Regular expression for basic email validation
        var regex = /^\S+@\S+\.\S+$/;
        if(regex.test(email) === false) {
        	event.preventDefault();
            printError("emailErr", "Please enter a valid email address");
            emailErr=true;
        } else{
            printError("emailErr", "");
        }
    }
    
 
    if(mobile == "") {
    	event.preventDefault();
        printError("mobileErr", "Please enter your mobile number");
        mobileErr=true;
    } else {
        var regex = /^[1-9]\d{9}$/;
        if(regex.test(mobile) === false) {
        	event.preventDefault();
            printError("mobileErr", "Please enter a valid 10 digit mobile number");
            mobileErr=true;
        } else{
            printError("mobileErr", "");
        }
    }
    


    if(msg == "") {
    	event.preventDefault();
        printError("msgErr", "Please enter your subject");
        msgErr=true;
    } else {
                    
        if(msg.split(/\r\n|\r|\n/).length <=1) {
        	event.preventDefault();
            printError("msgErr", "Please enter a valid Message");
            msgErr=true;
        } else {
            printError("msgErr", "");
        }
    }
    
   
   

    if(nameErr || emailErr || mobileErr  || subErr || msgErr) {
        event.preventDefault();
        return false;
     } 
};