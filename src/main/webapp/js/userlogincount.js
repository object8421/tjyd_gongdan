function initlistPage() {
	$("#main-jqgrid").jqGrid({
		url:contextPath + "/userLoginCount_json.do",
		datatype: 'json',
		mtype:'GET',
		jsonReader:{
		root : "data", 
		page : "page",
		total: "totalPages",
		records: "recordCount",
		repeatitems: false,
		id: "0"
	  },
	    colNames:['公司ID','公司名称'],  
	    colModel :[                        
	      {name:'id', index:'id',align:'center', width:55}, 
	      {name:'name', index:'name', align:'center', width:90}, 
	      ],
	    pager: '#pager',
	    rowNum:10,
	    rowList:[10,20,30],
	    sortname: 'id',
	    sortorder: 'desc',
	    viewrecords: false,
	    gridview: true,
	    autowidth:true,
	    //width: 800,
	    height: 250
  });


}


