

function printError(elemId, hintMsg) {
    document.getElementById(elemId).innerHTML = hintMsg;
}


function validateForm() {

    var Companyname = document.getElementById('companyName').value;

    var roleApplied= document.getElementById('roleApplied').value;
    var firstN= document.getElementById('firstN').value;

    var lastN = document.getElementById('lastN').value;
    var lgender = document.getElementById('gender').value;
    var email = document.getElementById('email').value;
    var phonenum = document.getElementById('phonenum').value;
    var percentage = document.getElementById('percentage').value;

    var Percentage = document.getElementById('Percentage').value;

    var cgpa = document.getElementById('cgpa').value;

    var lines = document.getElementById('lines').value;
      
          var companyErr = roleErr=firstErr=lastErr=genderErr=emailErr=phoneErr=perErr=percenErr=cgpaErr=linesErr=true;

          if(lines == "") {
            printError("linesErr", "Please enter your subject");
        } else {
                        
            if(msg.split(/\r\n|\r|\n/).length <=1) {
                printError("linesErr", "Please enter a valid Message");
            } else {
                printError("linesErr", "");
                linesErr = false;
            }
        }
        

          if(cgpa == "") {
            printError("cgpaErr", "Please enter your name");
        } else {
            var regex = /^[+-]?\d+(\.\d+)?$/;                
            if(regex.test(cgpa) === false) {
                printError("cgpaErr", "Please enter a valid name");
            } else {
                printError("cgpaErr", "");
                cgpaErr = false;
            }
        }


          if(cgpa == "") {
            printError("cgpaErr", "Please enter your name");
        } else {
            var regex = /^[+-]?\d+(\.\d+)?$/;                
            if(regex.test(cgpa) === false) {
                printError("cgpaErr", "Please enter a valid name");
            } else {
                printError("cgpaErr", "");
                cgpaErr = false;
            }
        }



          if(Percentage == "") {
            printError("percenErr", "Please enter your name");
        } else {
            var regex = /^[+-]?\d+(\.\d+)?$/;                
            if(regex.test(Percentage) === false) {
                printError("percenErr", "Please enter a valid name");
            } else {
                printError("percenErr", "");
                percenErr = false;
            }
        }

          if(percentage == "") {
            printError("perErr", "Please enter your name");
        } else {
            var regex = /^[+-]?\d+(\.\d+)?$/;                
            if(regex.test(percentage) === false) {
                printError("perErr", "Please enter a valid name");
            } else {
                printError("perErr", "");
                perErr = false;
            }
        }

          if(lgender == "") {
            printError("genderErr", "Please enter your name");
        } else {
          genderErr = false;
        
        }
        if(phonenum == "") {
            printError("phoneErr", "Please enter your mobile number");
        } else {
            var regex = /^[1-9]\d{9}$/;
            if(regex.test(phonenum) === false) {
                printError("phoneErr", "Please enter a valid 10 digit mobile number");
            } else{
                printError("phoneErr", "");
                phoneErr = false;
            }
        }




          if(Companyname == "") {
            printError("companyErr", "Please enter your name");
        } else {
            var regex = /^[a-zA-Z\s]+$/;                
            if(regex.test(Companyname) === false) {
                printError("companyErr", "Please enter a valid name");
            } else {
                printError("companyErr", "");
                companyErr = false;
            }
        }



        if(roleApplied == "") {
            printError("roleErr", "Please enter your name");
        } else {
            var regex = /^[a-zA-Z\s]+$/;                
            if(regex.test(roleApplied) === false) {
                printError("roleErr ", "Please enter a valid name");
            } else {
                printError("roleErr ", "");
                roleErr = false;
            }
        }
        
        

        if(firstN == "") {
            printError("firstErr", "Please enter your name");
        } else {
            var regex = /^[a-zA-Z\s]+$/;                
            if(regex.test(firstN) === false) {
                printError("firstErr ", "Please enter a valid name");
            } else {
                printError("firstErr ", "");
                firstErr = false;
            }
        }
        
        if(lastN == "") {
            printError("firstErr", "Please enter your name");
        } else {
            var regex = /^[a-zA-Z\s]+$/;                
            if(regex.test(lastN) === false) {
                printError("lastErr ", "Please enter a valid name");
            } else {
                printError("lastErr ", "");
                lastErr = false;
            }
        }
        
        if(email == "") {
            printError("emailErr", "Please enter your email address");
        } else {
           var regex = /^\S+@\S+\.\S+$/;
            if(regex.test(email) === false) {
                printError("emailErr", "Please enter a valid email address");
            } else{
                printError("emailErr", "");
                emailErr = false;
            }
        }
        

    if((emailErr|| companyErr|| roleErr|| firstErr ||lastErr || genderErr|| phoneErr||perErr || percenErr  || cgpaErr || linesErr) == true) {
        return false;
     } 
}