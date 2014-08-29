/*
 * 요소기술 스크립트  
 */

// 숫자체크 
function isNumber(control, msg) {
	
	var val = control;
	var Num = "1234567890";
	for (i=0; i<val.length; i++) {
		if(Num.indexOf(val.substring(i,i+1))<0) {
			alert(msg+' 형식이 잘못되었습니다.');
			return false;
		}
	}
	return true;
}

function isNumber2(control, msg) {
	
	var val = control;
	var Num = "1234567890";
	for (i=0; i<val.length; i++) {
		if(Num.indexOf(val.substring(i,i+1))<0) {
			return false;
		}
	}
	return true;
}

// 날짜체크
function isDate(control, msg) {
	
	// '/'나 '-' 구분자 제거
	var val = getRemoveFormat(control);

	if(val!="") {
		// 숫자, length 확인
		if (isNumber2(val, msg) && val.length == 8) {
			var year = val.substring(0,4);
			var month = val.substring(4,6);
			var day = val.substring(6,8);
			
			// 유효날짜 확인
			if(checkDate(year,month,day,msg)){
				return true;
			} else {
				return false;
			}
		} else {
			alert(msg + " 유효하지 않은 년,월,일(YYYYMMDD)입니다. 다시 확인해 주세요!");
			return false;
		}
	}
}

// 구분자 제거
function getRemoveFormat(val) {
	if(val.length == 10) {
		var arrDate = new Array(3);
		arrDate = val.split("/");
		if(arrDate.length != 3) {
			arrDate = val.split("-");
		}
		return arrDate[0] + arrDate[1] + arrDate[2];
	} else {
		return val;
	}	
}

// 유효날짜 확인
function checkDate(varCk1, varCk2, varCk3, msg) {
	if (varCk1>="0001" && varCk1<="9999" && varCk2>="01" && varCk2<="12") {
		febDays = "29";
		if ((parseInt(varCk1,10) % 4) == 0) {
			if ((parseInt(varCk1,10) % 100) == 0 && (parseInt(varCk1,10) % 400) != 0){
				febDays = "28";
			}
		}else{
			febDays = "28";
		}
		if (varCk2=="01" && varCk3>="01" && varCk3<="31") return true;
		if (varCk2=="02" && varCk3>="01" && varCk3<=febDays) return true;
		if (varCk2=="03" && varCk3>="01" && varCk3<="31") return true;
		if (varCk2=="04" && varCk3>="01" && varCk3<="30") return true;
		if (varCk2=="05" && varCk3>="01" && varCk3<="31") return true;
		if (varCk2=="06" && varCk3>="01" && varCk3<="30") return true;
		if (varCk2=="07" && varCk3>="01" && varCk3<="31") return true;
		if (varCk2=="08" && varCk3>="01" && varCk3<="31") return true;
		if (varCk2=="09" && varCk3>="01" && varCk3<="30") return true;
		if (varCk2=="10" && varCk3>="01" && varCk3<="31") return true;
		if (varCk2=="11" && varCk3>="01" && varCk3<="30") return true;
		if (varCk2=="12" && varCk3>="01" && varCk3<="31") return true;
	}
	alert(msg + " 유효하지 않은 년,월,일(YYYYMMDD)입니다. 다시 확인해 주세요!");
	return false;
}

//포커스 포커스 아웃시 포맷 설정
function setInFocusFormat(obj) {	
	if(obj.value!="") {
		obj.value = getRemoveFormat(obj.value);
		obj.select();
	}
} 

//포커스 포커스 아웃시 포맷 설정
function setOutFocusFormat(obj,obj2) {	
	if(obj.value!="") {
		if(isDate(obj.value, "")) {
			obj.value = getRemoveFormat(obj.value);
			var year = obj.value.substring(0,4);
	        var month = obj.value.substring(4,6);
	        var day = obj.value.substring(6,8);	        
	        obj.value = year +"-"+ month +"-"+ day;	  
	        obj2.value = obj.value;
		}else {
			obj.value = "";
			obj2.value = "";
			obj.focus();
		}	
	}
}

//포커스 포커스 아웃시 포맷 설정
function setOutFocusFormat2(obj) {	
	if(obj.value!="") {
		if(isDate(obj.value, "")) {
			obj.value = getRemoveFormat(obj.value);
			var year = obj.value.substring(0,4);
	        var month = obj.value.substring(4,6);
	        var day = obj.value.substring(6,8);	        
	        obj.value = year +"-"+ month +"-"+ day;	        
		}else {
			obj.value = "";
			obj.focus();
		}	
	}
}

function trim(str) {
	return str.replace(/^\s*|\s*$/g,"");
}

function isNum() {
    var mkey = event.keyCode;
    alert("mkey == "+mkey);
    if ( (mkey<48 || mkey>57) ) {
        event.returnValue = false;
    }
}

//영문,숫자만 입력 written by KDH
function isAlphaNum(){ 
	var mkey = event.keyCode; 
	if ( (mkey<48||mkey>57) &&(mkey<65||mkey>90)&&(mkey<97||mkey>122))  { 
		event.returnValue=false; 
	}    
} 




