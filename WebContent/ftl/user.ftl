<html>
  <head>
    <meta charset="utf8">
    <title>test</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- Bootstrap -->
    <#include "common-js.ftl"/>
  </head>
  <body>

    <#include "head.ftl"/>
    <#include "functionList.ftl"/>
      <div class="span9">
        <div>
          <table class="table table-hover" >
            <tr>
              <td align="center">用户名</td>
              <td align="center"><input type="text" name="name"></td>
              <td align="center">用户类型</td>
              <td align="center">
                <select name="utype">
                  <option >普通用户</option><option >管理员</option>
                </select>
              </td>
              <td><input type="button" class="btn btn-success" value="查询"></td>
            </tr>
            
          </table>
        </div>

        <div>
          <a href="#myModal" role="button" class="btn btn-info" data-toggle="modal">增加用户</a>
          <input type="button" class="btn btn-warning" value="删除用户">
        </div>
        <br>
        <div>
          <table class="table" >
            <tr style="background-color:#0088CC">
              <td align="center"><input type="checkbox"><font color="white">全选</font></td>
              <td align="center"><font color="white">序号</font></td>
              <td align="center"><font color="white">用户名</font></td>
              <td align="center"><font color="white">类型</font></td>
              <td align="center"><font color="white">操作</font></td>
            </tr>
            <#list userDo as user>
            <#--这是一段注释-->
      		<tr>
      			<td><input type="checkbox"></td>
        		<td>${user.id}</td>
        		<td>${user.name}</td>
        		<td><#if user.auth = 1>管理员</#if><#if user.auth = 2>普通用户</#if></td>
        		<td><a href="#update" role="button" class="btn btn-info" data-toggle="modal">更新</a></td>
      		</tr>
      		</#list>
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
        <h3 id="myModalLabel">增加用户</h3>
      </div>
      <div class="modal-body">
      <form action="addUser.do" method="post">
        <table class="table table-hover" >
            <tr>
              <td align="center">用户名</td>
              <td align="center"><input type="text" name="name"></td>
            </tr>
            <tr>
              <td align="center">用户类型</td>
              <td align="center">
                <select name="auth">
                  <option value=2>普通用户</option>
                  <option value=1>管理员</option>
                </select>
              </td>
            </tr>
            <tr>
              <td align="center">密码</td>
              <td align="center"><input type="text" name="pwd"></td>
            </tr>
            <tr>
              <td colspan="2"><button class="btn btn-success" type="submit">新增</button></td>
            </tr>
        </table>
        </form>
      </div>
      <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
      </div>
    </div>

    <!-- update -->
    <div id="update" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">更新用户</h3>
      </div>
      <div class="modal-body">
        <table class="table table-hover" >
            <tr>
              <td align="center">有户名</td>
              <td align="center"><input type="text" name="name" value="user1"></td>
            </tr>
            <tr>
              <td align="center">用户类型</td>
              <td align="center">
                <select name="utype">
                  <option >普通用户</option><option >管理员</option>
                </select>
              </td>
            </tr>
            <tr>
              <td align="center">密码</td>
              <td align="center"><input type="text" name="password" value="123456"></td>
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