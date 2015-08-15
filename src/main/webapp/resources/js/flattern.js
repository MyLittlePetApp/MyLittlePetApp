// jQuery for Flattern Landing Page
jQuery(document).ready(function($) {

// jQuery Flexslider ------------------------------------------------------ //
	$('.flexslider').flexslider({
		animation: "slide"
	});

// jQuery PrettyPhoto ------------------------------------------------------ //	
	 $("a[rel^='prettyPhoto']").prettyPhoto();
	 
// jQuery ScrollTo ------------------------------------------------------ //	  
	  $('.price').click(function(){
			$.scrollTo('#pricing-plans', 1000 );
	  });

// jQuery ToTop ------------------------------------------------------ //
	 $(".toTop").hide();
		
	 $(function () {
	 	$(window).scroll(function () {
		    if ($(this).scrollTop() > 200) {
		    	$('.toTop').fadeIn();
		        } else {
		        	$('.toTop').fadeOut();
		     }
		 });        
	 });        
		
	var easing, e, pos;
	    $(function(){
	      $(".toTop").on("click", function(){
	        pos= $(window).scrollTop();
	        $("body").css({
	          "margin-top": -pos+"px",
	          "overflow-y": "scroll", 
	        });
	        $(window).scrollTop(0);
	        $("body").css("transition", "all 2s ease");
	        $("body").css("margin-top", "0");
	        $("body").on("webkitTransitionEnd transitionend msTransitionEnd oTransitionEnd", function(){
	          $("body").css("transition", "none");
	        });
	      });
		
	  });

// Contact Form Validation ------------------------------------------------------ //
        $('#send_message').click(function(e){
            
            //Stop form submission & check the validation
            e.preventDefault();
            
            // Variable declaration
            var error = false;
            var name = $('#fname').val();
            var email = $('#email').val();
            var inquiry = $('#inquiry').val();
            var message = $('#message').val();
            
         	// Form field validation
            if(name.length == 0){
                var error = true;
                $('#name_error').fadeIn(500);
            }else{
                $('#name_error').fadeOut(500);
            }
            if(email.length == 0 || email.indexOf('@') == '-1'){
                var error = true;
                $('#email_error').fadeIn(500);
            }else{
                $('#email_error').fadeOut(500);
            }
            if(inquiry.length == 0){
                var error = true;
                $('#inquiry_error').fadeIn(500);
            }else{
                $('#inquiry_error').fadeOut(500);
            }
            if(message.length == 0){
                var error = true;
                $('#message_error').fadeIn(500);
            }else{
                $('#message_error').fadeOut(500);
            }
            
            // If there is no validation error, next to process the mail function
            if(error == false){
               // Disable submit button just after the form processed 1st time successfully.
                $('#send_message').attr({'disabled' : 'true', 'value' : 'Sending...' });
                
				/* Post Ajax function of jQuery to get all the data from the submission of the form as soon as the form sends the values to email.php*/
                $.post("contact.php", $("#contact_form").serialize(),function(result){
                    //Check the result set from email.php file.
                    if(result == 'sent'){
                        //If the email is sent successfully, remove the submit button
                         $('#submit').remove();
                        //Display the success message
                        $('#mail_success').fadeIn(500);
                    }else{
                        //Display the error message
                        $('#mail_fail').fadeIn(500);
                        // Enable the submit button again
                        $('#send_message').removeAttr('disabled').attr('value', 'Send');
                    }
                });
            }
        });
        
// Subscribe Form Validation ------------------------------------------------------ //
 		$('#subscribe_btn').click(function(e){
 			e.preventDefault();
 			
 			var subscribe_error = false;
 			var subscribe_email = $('#subscribe_email').val();
 			
 			if(subscribe_email.length == 0 || subscribe_email.indexOf('@') == '-1'){
	 			var subscribe_error = true;
	 			$('#subscribe_error').fadeIn(500);
 			}else{
	 			$('#subscribe_error').fadeOut(500);
 			}
 			
 			if(subscribe_error == false){
	 			$('#subscribe_btn').attr({'disabled' : 'true', 'value' : 'Sending...' });
	 			
	 			$.post("subscribe.php", $("#subscribe_form").serialize(),function(result){
                    if(result == 'sent'){
                        //Display the success message
                        $('#subscribe_success').fadeIn(500);
                    }else{
                        //Display the error message
                        $('#subscribe_fail').fadeIn(500);
                    }
                });
            }
 		});    
 			  
});