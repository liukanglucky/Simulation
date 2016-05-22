/**
 * 导出word
 */
function getExportPath() {
	var shell = new ActiveXObject("Shell.Application");
	var folder = shell.BrowseForFolder(0, '请选择存储目录', 0x0040, 0x11); 
	var filePath;
	if(folder != null) {
		 filePath = folder.Items().Item().Path;
	}
	return filePath;
}

//导出html
function exportHtml() {
	var filePath = getExportPath();
	if(filePath != null) {
		var file;
		try {
			var fso = new ActiveXObject("Scripting.FileSystemObject");  
			file = fso.createtextfile(filePath + "/导出.html",true);// 创建文件
			file.WriteLine(content.innerHTML);// 写入数据
			alert("导出成功");
		} catch (e) {
			alert("导出失败");
		} finally {
			if(file != null) 
				file.close();// 关闭连接
		}
	}
}
//word
function exportWord() {
	var filePath = getExportPath();
	if(filePath != null) {
		try {
			var word = new ActiveXObject("Word.Application");
			var doc = word.Documents.Add("", 0, 1);
			var range = doc.Range(0, 1);
			var sel = document.body.createTextRange();
			try {
				sel.moveToElementText(content);
			} catch (notE) {
				alert("导出数据失败，没有数据可以导出。");
				window.close();
				return;
			}
			sel.select();
			sel.execCommand("Copy");
			range.Paste();
			//word.Application.Visible = true;// 控制word窗口是否显示
			doc.saveAs(filePath + "/导出.doc");// 保存
			alert("导出成功");
		} catch (e) {
			alert("导出数据失败，需要在客户机器安装Microsoft Office Word(不限版本)，将当前站点加入信任站点，允许在IE中运行ActiveX控件。");
		} finally {
			try {word.quit();// 关闭word窗口
			} catch (ex) {}
			}
		}
	}

//export pdf
function exportPdf(){
	var filePath = getExportPath();
	if(filePath != null) {
		try {
			var word = new ActiveXObject("Word.Application");
			var doc = word.Documents.Add("", 0, 1);
			var range = doc.Range(0, 1);
			var sel = document.body.createTextRange();
			try {
				sel.moveToElementText(content);
			} catch (notE) {
				alert("导出数据失败，没有数据可以导出。");
				window.close();
				return;
			}
			sel.select();
			sel.execCommand("Copy");
			range.Paste();
			//word.Application.Visible = true;// 控制word窗口是否显示
			doc.saveAs(filePath + "/导出.pdf", 17);// 保存为pdf格式
			alert("导出成功");
		} catch (e) {
			alert("导出数据失败，需要在客户机器安装Microsoft Office Word 2007以上版本，将当前站点加入信任站点，允许在IE中运行ActiveX控件。");
		} finally {
			try {word.quit();// 关闭word窗口
			} catch (ex) {}
			}
		}
	}



function fake_click(obj) {
    var ev = document.createEvent("MouseEvents");
    ev.initMouseEvent(
        "click", true, false, window, 0, 0, 0, 0, 0
        , false, false, false, false, 0, null
        );
    obj.dispatchEvent(ev);
}
 
function export_raw(name, data) {
   var urlObject = window.URL || window.webkitURL || window;
 
   var export_blob = new Blob([data]);
 
   var save_link = document.createElementNS("http://www.w3.org/1999/xhtml", "a")
   save_link.href = urlObject.createObjectURL(export_blob);
   save_link.download = name;
   fake_click(save_link);
}

function exportHtml2(){
	var test=document.getElementsByTagName('html')[0].outerHTML;
	console.log(test);
	export_raw('test.html', test);
}

function exportImg(event){
	   event.preventDefault();
       html2canvas(document.body, {
       allowTaint: true,
       taintTest: false,
       onrendered: function(canvas) {
           canvas.id = "mycanvas";
           //document.body.appendChild(canvas);
           //生成base64图片数据
           var dataUrl = canvas.toDataURL();
           //alert(dataUrl);
           
           var imgData = dataUrl;
           var doc = new jsPDF();

           doc.setFontSize(40);
           //doc.text(35, 25, "Paranyan loves jsPDF");
           doc.addImage(imgData, 'PNG', 15, 40, 180, 160);
           
           var name = prompt("请输入保存文件名", ""); //将输入的内容赋给变量 name ，  
           
           //这里需要注意的是，prompt有两个参数，前面是提示的话，后面是当对话框出来后，在对话框里的默认值  
           if (name)//如果返回的有内容  
           {  
        	   doc.save(name+".pdf"); 
           }  
           
          
           //以下代码为下载此图片功能 
//           var triggerDownload = $("<a>").attr("href", dataUrl).attr("download", "img.png").appendTo("body"); 
//           triggerDownload[0].click(); 
//           triggerDownload.remove();
//
//           var newImg = document.createElement("img");
//           newImg.src =  dataUrl;
//           document.body.appendChild(newImg);
       }
   });
}