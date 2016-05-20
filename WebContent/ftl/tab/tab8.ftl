 <div class="tab-pane" id="tab8">
            <table border="0" cellpadding="1" cellspacing="1" style="width: 100%;">
              <tbody>
                <tr>
                  <td>海底地貌</td>
                  <td><select name="type1" style="width:60px;  height:20px">
                        <option value="1">平底</option>
                        <option value="2">斜坡</option>
                        <option value="3">海沟</option>
                        <option value="4">海山</option>
                </select></td>
                  <td>海底衰减系数</td>
                  <td><input name="ss2" style="width:60px;" type="text"></td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                  <td>中心频率</td>
                  <td><input name="fre" style="width:60px;" type="text"></td>
                  <td>输出距离步长</td>
                  <td><input name="len1" style="width:60px;" type="text"></td>
                  <td>&nbsp;</td>
                  <td>接收阵信息</td>
                  <td><select name="type5" style="width:60px;  height:20px">
                        <option value="1">单元发射</option>
                        <option value="2">线阵列</option>
                        <option value="3">面阵</option>
                </select></td>
                </tr>
                <tr>
                  <td>海面风速</td>
                  <td><input name="wspeed" style="width:60px;" type="text"></td>
                  <td>工作频段</td>
                  <td><input name="frew" style="width:60px;" type="text"></td>
                  <td><input name="frew" style="width:60px;" type="text"></td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                  <td>发射声源级</td>
                  <td><input name="sn" style="width:60px;" type="text"></td>
                  <td>射线数量</td>
                  <td><input name="num2" style="width:60px;" type="text"></td>
                  <td>&nbsp;</td>
                  <td>最大距离</td>
                  <td><input name="len2" style="width:60px;" type="text"></td>
                </tr>
                <tr>
                  <td>发射阵信息</td>
                  <td><select name="type3" style="width:60px;  height:20px">
                        <option value="1">单元发射</option>
                        <option value="2">线阵列</option>
                        <option value="3">面阵</option>
                </select></td>
                  <td>收发间距</td>
                  <td><input name="len3" style="width:60px;" type="text"></td>
                  <td>&nbsp;</td>
                  <td>计算频率点数</td>
                  <td><input name="num3" style="width:60px;" type="text"></td>
                </tr>
                <tr>
                  <td>发射信号形式</td>
                  <td><select name="type4" style="width:60px;  height:20px">
                        <option value="1">带宽噪声</option>
                        <option value="2">CW</option>
                </select></td>
                  <td>海况</td>
                  <td><input name="type2" style="width:60px;" type="text"></td>
                  <td>&nbsp;</td>
                  <td>海底底质类型</td>
                  <td><select name="type6" style="width:60px;  height:20px">
                        <option value="1">粘土</option>
                        <option value="2">粉砂</option>
                        <option value="3">沙石</option>
                        <option value="4">砾石</option>
                        <option value="5">白垩</option>
                        <option value="6">石灰石</option>
                        <option value="7">玄武岩</option>
                </select></td>
                </tr>
                <tr>
                  <td>海深个数</td>
                  <td><input name="num1" style="width:60px;" type="text"></td>
                  <td>发射换能器初始坐标</td>
                  <td><input name="cord" style="width:60px;" type="text"></td>
                  <td><input name="cord" style="width:60px;" type="text"></td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                  <td>海面反射</td>
                  <td><input name="ss1" style="width:60px;" type="text"></td>
                  <td>发射指向性</td>
                  <td><input name="ss3" style="width:60px;" type="text"></td>
                  <td>&nbsp;</td>
                  <td>接收深度</td>
                  <td><input name="dep" style="width:60px;" type="text"></td>
                </tr>
                <tr id="tab8file1">
                	
                </tr>
                <tr id="tab8file2">	
                	
                </tr>
                <tr id="tab8file3">	
                	
                </tr>
              </tbody>
            </table>
            
            <input type="button" class="btn btn-warning" value="保存数据" id="tab8save"
							onClick="autoGetVal('tab8','8','8');">
						<input type="button" class="btn btn-success" value="开始仿真"
							onClick="run('tab8','8','8');">
          </div>