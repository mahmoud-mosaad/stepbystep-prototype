	function validateForm() {

	    var x = document.forms["myform"]["FName"].value;
	    var y = document.forms["myform"]["LName"].value;
	    var z = document.forms["myform"]["Email"].value;
	    var p1 = document.forms["myform"]["password1"].value;
	    var p2 = document.forms["myform"]["password2"].value;
	    var t = document.getElementById("Type");
		var userType = t.value;
	    var g = document.getElementById("Gender");
		var gend = g.value;
	    var i=0;
	    var counter=0;
	    var text = "";
	    if ((x == "") || (y =="") || (z=="") || (p1=="") || (p2=="")) {
	        return false;
	    }
	    else{
	    	for (i = 0; i < x.length; i++) {
	    		var c = x[i];
	    		
	   			if (c >= '0' && c <= '9') {
    				document.getElementById("error").innerHTML = 'Invalid Name. Name Must only contain characters from [A-Za-z]';
    				return false;
    			}
    			else if(c == ' '){
    				document.getElementById("error").innerHTML = 'Invalid Name. Name Must only contain characters from [A-Za-z]';
    				return false;
    			}
    			else if(c < 'A' || c > 'z'){
    				document.getElementById("error").innerHTML = 'Invalid Name. Name Must only contain characters from [A-Za-z]';
    				return false;
    			}
			}
			for (i = 0; i < y.length; i++) {
	    		var c2 = y[i];
	    		
	   			if (c2 >= '0' && c2 <= '9') {
    				document.getElementById("error").innerHTML = 'Invalid Name. Name Must only contain characters from [A-Za-z]';
    				return false;
    			}
    			else if(c2 == ' '){
    				document.getElementById("error").innerHTML = 'Invalid Name. Name Must only contain characters from [A-Za-z]';
    				return false;
    			}
    			else if(c2 < 'A' || c2 > 'z'){
    				document.getElementById("error").innerHTML = 'Invalid Name. Name Must only contain characters from [A-Za-z]';
    				return false;
    			}
			}

			if(z.includes('@')){
				var atcounter = 0;
				var dotcounter = 0;
				var atIndex = 0;
				var dotIndex = 0;
				for(i=0;i<z.length;i++){
					var c3 = z[i];
					if(c3 == ' '){
						document.getElementById("error").innerHTML = 'Invalid Email. Email must not contain spaces';
    					return false;
					}
					else if(c3 == '@'){
						atIndex = i;
						atcounter++;
					}
					else if(c3 == '.'){
						dotIndex = i;
						dotcounter++;
					}
				}
				if((atcounter > 1) || (dotcounter>2 || dotcounter<1) || (dotIndex<atIndex)){
					document.getElementById("error").innerHTML = 'Invalid Email. Email must be like "User@hotmail.com"';
    				return false;
				}
			}
			else{
					document.getElementById("error").innerHTML = 'Invalid Email. Email must be like "User@hotmail.com"';
    				return false;
			}

			if(p1.length < 8 || p2.length < 8){
				document.getElementById("error").innerHTML = 'Invalid Password. password must be at least 8 characters';
    			return false;
			}
			else if(p1 != p2){
				document.getElementById("error").innerHTML = 'Invalid Password. passwords doesnt match';
    			return false;
			}
			
	    }

	    if(userType!="teacher" && userType!="student"){
	    	document.getElementById("error").innerHTML = 'Invalid Type. Enter, student or teacher';
    		return false;
	    }

	    if(gend!="male" && gend!="female"){
	    	document.getElementById("error").innerHTML = 'Invalid gender input, Enter male or female';
    		return false;
	    }
	}
		