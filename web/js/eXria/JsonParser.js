/**
 * @fileoverview
 * Instance를 기준으로 AutoCRUD Data를 Parsing 해주는 클래스
 */
/**
 * Instance를 기준으로 AutoCRUD Data를 Parsing 해주는 클래스
 */
JsonParser=function(){
  /**
   * @private
   */
  this.instanceId = null;
  /**
   * @private
   */
  this.xpath = null;
  /**
   * @private
   */
  this.ts={}; // cud target tables
  /**
   * @private
   */
  this.t=function(){
  	/**
  	 * @private
  	 */
  	this.id=null;
  	/**
  	 * @private
  	 */
  	this.updateCols={};// update column
  	/**
  	 * @private
  	 */
  	this.pks={}; // pk list
  	/**
  	 * @private
  	 */
  	this.prefix=null;
  	/**
  	 * @private
  	 */
  	this.usrStr="";
  	/**
  	 * @private
  	 */
  	this.setId=function(id){
  		this.id=id;
  	};
  	/**
  	 * @private
  	 */
  	this.getId=function(){
  		return this.id;
  	};
  	/**
  	 * @private
  	 */
  	this.addUpdateCol=function(dbId, id){
  		this.updateCols[dbId]=id;
  	};
  	/**
  	 * @private
  	 */
  	this.removeUpdateCol=function(dbId){
  		delete this.updateCols[dbId];
  	};
  	/**
  	 * @private
  	 */
  	this.clearUpdateCol=function(){
  		this.updateCols=null;
  		this.updateCols={};
  	};
  	/**
  	 * @private
  	 */
  	this.getUpdateCols=function(){
  		return this.updateCols;
  	};
  	/**
  	 * @private
  	 */
  	this.addPk=function(dbId, id){
  		this.pks[dbId]=id;
  	};
  	/**
  	 * @private
  	 */
  	this.getPk=function(pk){
  		return this.pks[pk];
  	};
  	/**
  	 * @private
  	 */
  	this.getPks=function(){
  		return this.pks;
  	};
  	/**
  	 * @private
  	 */
  	this.getAllPk=function(){
  		return this.pks;
  	};
  	/**
  	 * @private
  	 */
  	this.rmPk=function(dbId){
  		delete this.pks[dbId];
  	};
  	/**
  	 * @private
  	 */
  	this.clearPk=function(){
  		this.pks=null;
  		this.pks={};
  	};
  	/**
  	 * @private
  	 */
  	this.setPrefix=function(p){
  		this.prefix=p;
  	};
  	/**
  	 * @private
  	 */
  	this.getPrefix=function(){
  		return this.prefix;
  	};
  	/**
  	 * @private
  	 */
  	this.setUsrStr=function(s){
  		if(!s) s="";
  		this.usrStr=s;
  	};
  	/**
  	 * @private
  	 */
  	this.getUsrStr=function(s){
  		return this.usrStr;
  	};
  	/**
  	 * @private
  	 */
  	this.resetUsrStr=function(){
  		this.usrStr="";
  	};
  	/**
  	 * @private
  	 */
  	this.resetTable=function(){
  		this.id=null;
  		this.pks=null;
  		this.pks={};
  		this.updateCols=null;
  		this.updateCols={};
  		this.prefix=null;
  	};
  };
  /**
   * @private
   */
  this.prefixList=[];
  /**
   * @private
   */
  this.getRandomPrefix=function (){
		return "T@"+Math.floor((Math.random() * (99 - 10+1))+10);
	};
  /**
   * @private
   */
  this.prefixGen=function(){
  	var p=null;
  	do{
  		p=this.getRandomPrefix();
  	} while(this.prefixList[p]!=null);
  	return p;
  };
  /**
   * @private
   */
  this.clearPrefix=function(){
  	this.prefixList=null;
  	this.prefixList=[];
  };
   //########### 외부 노출 API 시작
  /**
   * Primary Key로 쓰일 Column을 추가 한다.
   * @param tName 추가하고자 하는 DB Table 명
   * @param colName node 명
   * @param pkName DB에서 사용 할 Primary Key Column 명
   * @return void
   * @type void
   */
  this.addPrimaryKey=function(tName, colName, pkName){
  	var t=this.ts[tName];
  	if(t==null)
  		return;
  	t.addPk(pkName, colName);
  };
  /**
   * Primary Key로 쓰일 컬럼을 삭제 한다.
   * @param tName 삭제하고자 하는 타겟 DB Table 명
   * @param pkName 타겟 DB에서 사용 될 Primary Key Column 명
   * @return void
   * @type void
   */
  this.removePrimaryKey=function(tName, pkName){
  	var t=this.ts[tName];
  	if(t==null)
  		return;
  	t.rmPk(pkName);
  };
  /**
   * Primary Key를 모두 삭제한다.
   * @param tName 삭제하고자 하는 타겟 DB Table 명
   * @return void
   * @type void
   */
  this.clearPrimaryKeys=function(tName){
  	var t=this.ts[tName];
  	if(t==null)
  		return;
  	t.clearPk();
  };
  /**
   * CRUD 타겟 DB Table을 지정한다.
   * @param tName 타겟 DB Table 명
   * @return void
   * @type void
   */
  this.addCRUDTable=function(tName){
  	var t=new this.t();
  	t.setId(tName);
  	t.setPrefix(this.prefixGen());
  	this.ts[tName]=t;
  };
  /**
   * Update Column을 추가한다.
   * @param tName 타겟 DB Table 명
   * @param colId node 명
   * @param dbColId 타겟 DB에서 사용 될 Column 명
   * @return void
   * @type void
   */
  this.addUpdateColumn=function(tName, colId, dbColId){
  	var t=this.ts[tName];
  	if(t==null)
  		return;
  	if(t.getPk(dbColId)!=null) return;
  	t.addUpdateCol(dbColId, colId);
  };
  /**
   * Update Column을 삭제한다.
   * @param tName 타겟 DB Table 명
   * @param dbColId 삭제할 DB Column 명
   * @return void
   * @type void
   */
  this.removeUpdateColumn=function(tName, dbColId){
  	var t=this.ts[tName];
  	if(t==null)
  		return;
  	t.removeUpdateCol(dbColId);
  };
  /**
   * Update Column을 모두 삭제한다.
   * @param tName 타겟 DB Table 명
   * @return void
   * @type void
   */
  this.clearUpdateColumns=function(tName){
  	var t=this.ts[tName];
  	if(t==null)
  		return;
  	t.clearUpdateCol();
  };
  /**
   * 타겟 DB의 Primary key 명을 "," 구분자로 구분하여 리턴한다.
   * @param tName 타겟 DB Table 명
   * @return "," 구분자로 분리 된 Primary Key 명
   * @type String
   */
  this.getPrimaryKeys=function(tName){
  	var t=this.ts[tName];
  	var pk=t.getPks();
  	var s="";
  	for(var m in pk){
  		s=s+pk[m]+",";
  	}
  	s=s.substring(0, s.length-1);
  	return s;
  };
  /**
   * CRUD 타겟 테이블에서 제외 시킨다.
   * @param tName 제외 시키고자 하는 타겟 DB Table 명
   * @return void
   * @type void
   */
  this.removeCRUDTable=function(tName){
  	delete this.ts[tName];
  };
  /**
   * CRUD 타겟 DB Table 명을 "," 구분자로 구분하여 리턴한다.
   * @return "," 구분자로 분리 된 타겟 DB Table 명
   * @type String
   */
  this.getCRUDTableNames=function(){
  	var t=this.ts;
  	var s="";
  	for(var m in t){
  		s=s+t[m].getId()+",";
  	}
  	s=s.substring(0, s.length-1);
  	
  	return s;
  };
  /**
   * AutoCRUD 적용 시 서버로 보낼 파싱 된 데이터를 리턴한다.
   * @return CRUD Data String
   * @type String
   */
  this.getAutoCRUDString=function(){
  	return this.parse();
  };
  /**
   * 데이터를 관리할 Instance 정보를 셋팅한다.
   * @param id instance id
   * @param xpath 사용할 xpath
   * @return void
   * @type void
   */
  this.setInstanceInfo=function(id, xpath){
  	this.instanceId = id;
  	this.xpath = xpath;
  };
  /**
   * 서버로 보낼 CRUD 데이터에 임의의 String을 추가한다.
   * @param tName 타겟 DB Table 명
   * @param str 추가할 데이터
   * @return void
   * @type void
   */
  this.addCRUDString=function(tName, str){
  	var t=this.ts[tName];
  	if(t==null) return;
  	t.setUsrStr(str+"&");
  };
  /**
   * addCRUDString 메소드를 사용하여 추가하였던 데이터 String을 삭제한다.
   * 해당 작업이 이루어지지 않을 경우 모든 이전에 셋팅 되었던 데이터가 계속 포함되어 서버로 전송된다.
   * @param tName 타겟 DB Table 명
   * @return void
   * @type void
   */
  this.resetCRUDString=function(tName){
  	var t=this.ts[tName];
  	if(t==null) return;
  	t.resetUsrStr();
  };
  /**
   * 모든 CRUD 관련 데이터를 초기화 시킨다.
   * @return void
   * @type void
   */
  this.reset=function(){
  	var m;
  	for(m in this.ts){
  		this.ts[m].resetTable();
  		delete this.ts[m];
  	}
  	this.ts=null;
  	this.ts={};
  	this.clearPrefix();
  };
  /**
   * prefix를 지정한다.
   * @param tName 타겟 DB Table 명
   * @param prefix prefix
   * @return void
   * @type void
   * @private
   */
  this.setPrefix=function(tName, prefix){
  	var t=this.ts[tName];
  	if(t==null)
  		return;
  	t.setPrefix(prefix);
  };
  /**
   * prefix를 리턴한다.
   * @param tName 타겟 DB Table 명
   * @param prefix prefix
   * @return void
   * @type void
   * @private
   */
  this.getPrefix=function(tName){
  	var t=this.ts[tName];
  	if(t==null)
  		return null;
  	return t.getPrefix();
  };
  /**
   * setInstanceInfo 메소드를 통해 지정된 Instnace 및 XPath를 기준으로 하위 모든 Node의 Node명을 리턴한다.
   * return 받은 Node명은 addNodeNames 메소드를 통하여 update column으로 지정한다.
   * @return ","로 구분 된 노드명
   * @type String
   */
  this.getNodeNames=function(){
  	var ins=page.getInstance(this.instanceId);
  	var n=ins.selectSingleNode(this.xpath);
  	var cn=n.getChildNodes();
  	
  	var s="";
  	for(var i=0, len=cn.getLength() ; i < len ; i++){
  		n=cn.item(i);
  		if(n.getNodeType()!=1) continue;
  		s=s+n.getNodeName()+",";
  	}
  	s=s.substr(0, s.length - 1);
  	return s;
  };
  /**
   * ","으로 구분 된 update column명을 update target으로 추가한다.
   * @param tName update column을 지정할 table name
   * @param s ","으로 구분 된 column 명 리스트
   * @return void
   * @type void
   */
  this.addNodeNames=function(tName, s){
  	var t = this.ts[tName];
  	if(t==null) return;
  	if(s==null) return;
  	s=s.replace(/(^\s*)|(\s*$)/gi, "");
  	if(s.lastIndexOf(",")==(s.length-1)) {
  		s=s.substr(0,s.length-1);
  	}
  	var list=s.split(",");
  	var name;
  	for(var i=0,len=list.length ; i < len ; i++) {
  		name=list[i];
  		if(t.getPk(name)!=null) continue;
  		t.addUpdateCol(name, name);
  	}
  };
   //###### 외부 노출 API 끝	
  
   //###### Parsing 관련 속성/메소드	
  /**
   * @private
   */
  this.pkStr="PRIMARYKEYS";
  /**
   * @private
   */
  this.upCols="UPDATECOLUMNS";
  /**
   * @private
   */
  this.xr="XRAUTOCUD";
  /**
   * @private
   */
  this.org="__origin";
  /**
   * @private
   */
  this.crudType="CRUDTYPE";
  /**
   * @private
   */
  this.dataParse=function(t, nodes, status){
  	var p=t.getPks();
  	var u=t.getUpdateCols();
  	var s="";
  	var node, name;
  	
  	for(var i=0, len=nodes.getLength() ; i < len ; i++){
  		node=nodes.item(i);
//  		if(node.getNodeType()!=1) continue;
  		name=node.getNodeName();
  		
  		if(u[name] == null && p[name] == null) continue;
  		
  		s=s+encodeURIComponent(t.getPrefix()+name)+"="+encodeURIComponent(node.getNodeValue())+"&";
  		
  		if(p[name]!=null){
  			s=s+encodeURIComponent(t.getPrefix()+name+this.org)+"="+encodeURIComponent(node.getNodeValue())+"&";
  		}
  	}
  	s=s+encodeURIComponent(t.getPrefix()+this.crudType)+"="+encodeURIComponent(status)+"&";
  	return s;
  };
  
  /**
   * @private
   */
  this.tableParse=function(t){
  	var s="";
  	s=s+encodeURIComponent(t.getPrefix()+this.pkStr)+"=";

  	var pks=t.getPks();
  	var len=pks.length;
  	for (var m in pks){
  		s=s+encodeURIComponent(pks[m]+":"+pks[m]+",");
  	}
  	s=s+"&";
  	return s;
  };
  /**
   * @private
   */
  this.updateColParse=function(t){
  	var s="";
  	s=s+encodeURIComponent(t.getPrefix()+this.upCols)+"=";

  	var uCols=t.getUpdateCols();
  	for (var m in uCols){
  		s=s+encodeURIComponent(uCols[m]+":"+uCols[m]+",");
  	}
  	s=s+"&";
  	return s;
  };
  /**
   * @private
   */
  this.crudTableParse=function(){
  	var t=null;
  	var s=encodeURIComponent(this.xr)+"=";
  	for(var m in this.ts){
  		t=this.ts[m];
	  	s=s+encodeURIComponent(t.getPrefix()+":"+t.getId()+",");
  	}
  	s=s+"&";
  	return s;
  };
   //###### Parsing method 끝	
   //###### Parsing method 외부 노출 API
  /**
   * 설정 된 값을 바탕으로 CRUD 데이터를 Parsing 한다.
   * @return Parsing 된 String Data
   * @type String
   * @private
   */
  this.parse=function(){
  	var cudStr="";
  	var ins=page.getInstance(this.instanceId);
  	var nodes=ins.selectNodes(this.xpath);
  	var rNode, attr, status;
  	var t, s="";
  	
  	s=s+this.crudTableParse();
  	for (var m in this.ts){
  		t=this.ts[m];
  		s=s+this.tableParse(t);
			s=s+this.updateColParse(t);
		
  		for(var i=0, len=nodes.getLength() ; i < len ; i++){
    		rNode=nodes.item(i);
    		if(rNode.getNodeType()!=1) continue;
//    		attr=rNode.node;
			
    		try{
    			status=rNode.getAttribute("status");//attr.getAttribute("status");
    		} catch(e){ status=null; };
    		
    		if(status==null) continue;
    		
    		status=status.replace(/(^\s*)|(\s*$)/gi, "");
    		if(status == "") continue;
    		
    		//I:insert(단순 추가, 업데이트 대상 X), IU:(insert 후 업데이트 -> 업데이트 대상)
    		//U:update
    		//D:D(delete 업데이트대상),DI(insert 후 삭제 -> 업데이트대상X), DIU(insert 후 업데이트 후 삭제 -> 업데이트 대상X)
    		if(status=="U" || status=="IU" || status=="D" || status=="DU") {
    			status = status.substr(0,1);
    			s=s+this.dataParse(t, rNode.getChildNodes(), status);
    		} else {
    			continue;
    		}
    	}
  		s=s+t.getUsrStr();
  	}
  	return s;
    
  };
   //#### Parse 메소드 끝
   this.getObjectString = function(psTableName) {
    var tName = null;
    
    if(psTableName == null || psTableName == "") {
      tName = this.xpath.replace("/root/", "");
    } else {
      tName = psTableName;
    }
    
    this.addCRUDTable(tName);
    var ins = page.getInstance(this.instanceId);
    var n = ins.selectNodes(this.xpath);
    
    var cn = n.item(0).getChildNodes();
    var s = "";
    
    for(var i=0, len=cn.getLength(); i < len; i++){
      s = cn.item(i).name;
      this.addUpdateColumn(tName, s, s);
    }
    
    return this.getAutoCRUDString();
  };
};