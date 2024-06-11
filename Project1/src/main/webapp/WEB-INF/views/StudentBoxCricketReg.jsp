<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

	<h1>Box Cricket Registration </h1>
	<form action="/registerStudentBoxCricket" method="post" >
		Enter Name : <input type="text" name="studentName" value=${studentName} >
		<span class="error" style="color:red;margin-left:1rem;" >${studentNameError}</span>
		<br><br>
		Playing Type:
					<input type="radio" name="playerType" value="Bowler" ${BowlerChecked}>Bowler
					<input type="radio" name="playerType" value="Batsman" ${BatsmanChecked}>Batsman
					<input type="radio" name="playerType" value="AllRounder" ${AllRounderChecked}>All Rounder
					<span class="error" style="color:red;margin-left:1rem;">${playerTypeError}</span>
					<br><br>
		Food Preference: 
		
				<select name="foodPrefernce">
					<option value="-1">---Select Your Food Preference---</option>
					<option value="Regular" ${RegularSelected}>Regular</option>
					<option value="Jain" ${JainSelected}>Jain</option>
				</select>				
				<span class="error" style="color:red;margin-left:1rem;">${foodPreferenceError}</span>
				<br><br>
		Drink:
				<input type="checkbox" name="drink" value="rb" ${rbChecked} > RB
				<input type="checkbox" name="drink" value="md" ${mdChecked} > MD
				<input type="checkbox" name="drink" value="th" ${thChecked} > TH
				<input type="checkbox" name="drink" value="lj" ${ljChecked} > LJ
				<span class="error" style="color:red;margin-left:1rem;">${drinkError}</span>
				<br><br>
				
		<input type="submit" value="Register">					
	</form>
</body>
</html>