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
              <td align="center">声学特性</td>
              <td align="center"><input type="text" name="name"></td>
              <td><input type="button" class="btn btn-success" value="查询"></td>
            </tr>
            
          </table>
        </div>

        <div>
          <a href="#myModal" role="button" class="btn btn-info" data-toggle="modal">增加特性</a>
          <input type="button" class="btn btn-warning" value="删除特性">
        </div>
        <br>
        <div>
          <table class="table" >
            <tr style="background-color:#0088CC">
              <td align="center"><input type="checkbox"><font color="white">全选</font></td>
              <td align="center"><font color="white">声学特性ID</font></td>
              <td align="center"><font color="white">声学特性名</font></td>
              <td align="center"><font color="white">操作</font></td>
            </tr>
            <tr>
              <td><input type="checkbox"></td>
              <td>1</td>
              <td>舰艇目标声反射</td>
              <td><a href="#update" role="button" class="btn btn-info" data-toggle="modal">更新</a></td>
            </tr>
            <tr>
              <td><input type="checkbox"></td>
              <td>2</td>
              <td>高频模型</td>
              <td><a href="#update" role="button" class="btn btn-info" data-toggle="modal">更新</a></td>
            </tr>
            <tr>
              <td><input type="checkbox"></td>
              <td>3</td>
              <td>舰艇辐射</td>
              <td><a href="#update" role="button" class="btn btn-info" data-toggle="modal">更新</a></td>
            </tr>
            <tr>
              <td><input type="checkbox"></td>
              <td>4</td>
              <td>鱼雷辐射</td>
              <td><a href="#update" role="button" class="btn btn-info" data-toggle="modal">更新</a></td>
            </tr>
            <tr>
              <td><input type="checkbox"></td>
              <td>5</td>
              <td>舰艇白噪声</td>
              <td><a href="#update" role="button" class="btn btn-info" data-toggle="modal">更新</a></td>
            </tr>
            <tr>
              <td><input type="checkbox"></td>
              <td>6</td>
              <td>鱼雷白噪声</td>
              <td><a href="#update" role="button" class="btn btn-info" data-toggle="modal">更新</a></td>
            </tr>
            <tr>
              <td><input type="checkbox"></td>
              <td>7</td>
              <td>海洋环境</td>
              <td><a href="#update" role="button" class="btn btn-info" data-toggle="modal">更新</a></td>
            </tr>
            <tr>
              <td><input type="checkbox"></td>
              <td>8</td>
              <td>声传播</td>
              <td><a href="#update" role="button" class="btn btn-info" data-toggle="modal">更新</a></td>
            </tr>
          </table> 
        </div>
        <div class="pagination">
          <ul>
            <li class="disabled"><a href="#">&laquo;</a></li>
            <li class="active"><a href="#">1</a></li>
            <li ><a href="#">2</a></li>
            <li ><a href="#">3</a></li>
            <li ><a href="#">4</a></li>
            <li ><a href="#">5</a></li>
          </ul>
        </div>
      </div>
    </div>



    <!-- modal -->
    <!-- Modal -->
    <div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">增加声学特性</h3>
      </div>
      <div class="modal-body">
        <table class="table table-hover" >
            <tr>
              <td align="center">声学特性</td>
              <td align="center"><input type="text" name="name"></td>
            </tr>
            <tr>
              <td colspan="2"><input type="button" class="btn btn-success" value="新增"></td>
            </tr>
        </table>
      </div>
      <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
      </div>
    </div>

    <!-- update -->
    <div id="update" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">更新声学特性</h3>
      </div>
      <div class="modal-body">
        <table class="table table-hover" >
            <tr>
              <td align="center">声学特性</td>
              <td align="center"><input type="text" name="name" value="舰艇目标声反射"></td>
            </tr>
            <tr>
              <td colspan="2"><input type="button" class="btn btn-success" value="更新"></td>
            </tr>
        </table>
      </div>
      <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
      </div>
  </body>
</html>