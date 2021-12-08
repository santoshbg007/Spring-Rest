<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div style="background: #E0E0E0; height: 75px;">
	<div style="float: left">
		<h1 style="color: darkblue;">Company Portal</h1>
	</div>

	<div style="float: right; text-align: right;">

		<div align="center">
			<h1 style="color: darkblue;">Search Employee</h1>
			<form action="search" method="post">
				<input type="text" name="employeeName"
					placeholder="Search Employee By Name">
				<button type="submit" name="save">Search</button>
			</form>
		</div>

	</div>

</div>