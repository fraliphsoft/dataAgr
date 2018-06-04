var fsList = undefined;
var mongodbList = undefined;
var lodashList = undefined;

var table;

function initTable(tableEle) {
	table = tableEle;
	fsList = getFsMethods();
	loadTable(fsList);
}

function changeDataSource(libName) {
	var data;
	if (libName == 'fs') {
		$("#currentLib").html("fs");
		if (fsList == undefined) {
			fsList = getFsMethods();
		}
		data = fsList;
	} else if (libName == 'mongodb') {
		$("#currentLib").html("mongodb");
		if (mongodbList == undefined) {
			mongodbList = getMongodbMethods();
		}
		data = mongodbList;
	} else {
		$("#currentLib").html("lodash");
		if (lodashList == undefined) {
			lodashList = getLodashMethods();
		}
		data = lodashList;
	}
	loadTable(data);
}

function loadTable(data) {
	$(table).bootstrapTable("destroy");
	$(table).bootstrapTable({
		columns : [ {
			field : 'mid',
			visible: false
		}, {
			field : 'cname',
			title : 'Class'
		}, {
			field : 'mname',
			title : 'Method'
		}, {
			fiels : 'descrip',
			title : 'Description'
		} ],
		data : data,
		pagination : true,
		pageSize : 20,
		pageList : [20],
		search : true,
		onClickRow : function(row, $element, field) {
			var url = "../API_Stack/?mid=" + row.mid;
			window.location.href = url;
		}
	});
}

function getFsMethods() {
	return requestData("/API_Stack/fs/");
}

function getMongodbMethods() {
	return requestData("/API_Stack/mongodb/");
}

function getLodashMethods() {
	return requestData("/API_Stack/lodash/");
}

function requestData(url) {
	var data = new Array();
	$.ajax({
		type:		"Post",
		url:		url,
		contentType:"application/json",
		dataType:	"json",
		async:		false,
		success:	function(result) {
			$(result).each(function(index, val) {
				data.push({
					"mid" : val.mid,
					"cname" : val.cname,
					"mname" : val.mname,
					"descrip" : val.description
				});
			});
		},
		error:		function(result) {
			console.log(result);
		}
	});
	return data;
}