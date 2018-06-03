<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"></link>
		<link href="../css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"></link>
		<link href="../css/bootstrap-table.min.css" rel="stylesheet" type="text/css"></link>
		<link href="../css/style.css" rel="stylesheet" type="text/css"></link>
		<link href="../css/table.css" rel="stylesheet" type="text/css"></link>
		
		<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="../js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../js/bootstrap-table.min.js"></script>
		<script type="text/javascript" src="../js/bootstrap-table-zh-CN.min.js"></script>
		<script type="text/javascript" src="../js/dataImporter.js"></script>
		<title>WOW</title>
	</head>
	
	<body>
		<div class="navBoard">
			<div class="nav">
				<div class="libSearch">
					<div class="input-group-addon">当前库:</div>
					<div class="btn-group input-group-btn">
						<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							<div id="currentLib" style="display:inline-block;">fs</div><span class="caret" style="float:right;margin-top:7px;"></span>
						</button>
						<ul class="dropdown-menu">
							<li><a  href="#" onclick="changeDataSource('fs')">fs</a></li>
							<li class="divider"></li>
							<li><a href="#" onclick="changeDataSource('mongodb')">mongodb</a></li>
							<li class="divider"></li>
							<li><a href="#" onclick="changeDataSource('lodash')">lodash</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>