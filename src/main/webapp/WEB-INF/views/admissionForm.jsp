<!DOCTYPE html>
<html>
<head>
	<title>
		Admission Form Page
	</title>
</head>
<body>
	<h1>
		ADMISSION FORM PAGE
	</h1>
	<form action="/submitAdmissionForm" method="post">
		<table>
			<tr>
				<td> Student's Name</td> <td><input type="text" name="studentName" /> </td>
			</tr>
			<tr>
				<td> Student's Hobby</td> <td><input type="text" name="studentHobby" /> </td>
			</tr>
			<tr>
				<td> Student's Mobile</td> <td><input type="text" name="studentMobile" /> </td>
			</tr>
			<tr>
				<td> Student's DOB</td> <td><input type="text" name="studentDOB" /> </td>
			</tr>
			<tr>
				<td> Student's skills set</td>
				<td>
                    <select name="studentSkills" multiple>
                         <option value="Java Core"> Java Core</option>
                         <option value="Spring Core"> Spring Core</option>
                         <option value="Spring MVC Core"> Spring MVC Core</option>
                     </select>
				</td>
			</tr>
			<tr> <td><input type="submit" value="Submit Form" /> </td></tr>
		</table>
	</form>
</body>
</html>