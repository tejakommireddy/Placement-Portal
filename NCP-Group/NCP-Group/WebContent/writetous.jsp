<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<meta charset="ISO-8859-1">
<!DOCTYPE html>
<html>
    <head>
        <title>Contact US</title>
        <link rel="stylesheet" href="style_contact_us.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;800&display=swap" rel="stylesheet">
    	
    </head>

    <body>
        <div class="container">
            <h1>Contact Us</h1>
            <P>We would love to respond to your queries and help you succeed,
                <br>
                Feel free to get in touch with us.</P>
            <p> <b>Note: We will take 1-2 business days to respond.</b></p>
            <div class="contact_box">
                <div class="contact_left">
                    <h3>Request Sent</h3>
                    <form action="writetous" method="get" onsubmit="return validateForm()"> 
                    

                        <div class="input_row">
                            <div class="input_group">
                                <label>Name</label>
                                <input type="text" placeholder="enter name" id="name" name="name" required> 
                                <div class="error" id="nameErr"></div>
                             
                            </div>
                          

                            <div class="input_group">
                                <label>Phone</label>
                                <input type="text" id="contactph" placeholder="+91 99999 99999" required name="contactph"> 
                                <div class="error" id="mobileErr"></div>

                            </div>
                        </div>
                        <div class="input_row">
                            <div class="input_group">
                                <label>Email</label>
                                <input type="email"  id="contactemail" placeholder="xyz@gmail.com" name="contactemail">
                                <div class="error" id="emailErr"></div>
                                
                            </div>

                            <div class="input_group">
                                <label>Subject</label>
                                <input type="text" id="contactsub" placeholder="About" name="contactsub">
                                <div class="error" id="subErr"></div>
                            </div>
                        </div>

                        <label>Message</label>
                        <textarea rows="5" id="contactmsg" placeholder="Your Message.." name="contactmsg"></textarea>
                        <div class="error" id="msgErr"></div>

                        <button type="submit">Submit </button>

                    </form>
                </div>
                <div class="contact_right">
                    <h3>Request Us</h3>

                    <table>
                        <tr>
                            <td>Email</td>
                            <td>placement_page_proj@xyz.com</td>
                        </tr>
                        <tr>
                            <td>Phone</td>
                            <td>+91 99999 99999</td>

                        </tr>

                        <tr>
                            <td>Adress</td>
                            <td>Amritanagar, Ettimadai, Tamil Nadu 641112</td>
                        </tr>

                    </table>

                </div>

            </div>


        </div>



    </body>




</html>