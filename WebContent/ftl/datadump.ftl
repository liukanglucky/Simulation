<html>
  <head>
    <meta charset="utf8">
    <title>test</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <script src="js/jquery-1.8.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </head>
  <body>
    <#include "head.ftl"/>
    <#include "functionList.ftl"/>
      <div class="span9">
        <div>
          <table class="table table-hover" >
            <tr>
              <td align="center">导出模型</td>
              <td align="center">
                <select name="utype">
                  <option >模型1</option><option >模型2</option>
                </select>
              </td>
              <td align="center">导出路径</td>
              <td align="center"><input type="text" name="name"></td>
              
              <td><input type="button" class="btn btn-success" value="导出"></td>
            </tr>
            
          </table>
        </div>
  </body>
</html>