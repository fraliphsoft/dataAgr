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
		if (fsList == undefined) {
			fsList = getFsMethods();
		}
		data = fsList;
	} else if (libName == 'mongodb') {
		if (mongodbList == undefined) {
			mongodbList = getMongodbMethods();
		}
		data = mongodbList;
	} else {
		if (lodashList == undefined) {
			lodashList = getLodashMethods();
		}
		data = lodashList;
	}
	loadTable(data);
}

function loadTable(data) {
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
		search : true,
		onClickRow : function(row, $element, field) {
			alert(row.mid);
		}
	});
}

function getFsMethods() {
	return [{"mid":1, "cname":"fs", "mname":"yes", "descrip":"wwwwww"}];
}

function getMongodbMethods() {
	return [{"mid":1, "cname":"mongodb", "mname":"yes", "descrip":"wwwwww"}];
}

function getLodashMethods() {
	return [{"mid":1, "cname":"lodash", "mname":"yes", "descrip":"wwwwww"}];
}