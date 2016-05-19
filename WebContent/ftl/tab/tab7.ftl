<div class="tab-pane" id="tab7">
            <div class="span8">
              <table border="0" style="width: 100％;">
                <tbody>
                  <tr>
                    <td>海况</td>
                    <td><input name="seacon" style="width:60px;" type="text"></td>
                    <td>平均千米舰艇数</td>
                    <td><input name="num1" style="width:60px;" type="text"></td>
                  </tr>
                  <tr>
                    <td>海面风速</td>
                    <td><input name="wspeed" style="width:60px;" type="text"></td>
                    <td>长度</td>
                    <td><input name="lenth" style="width:60px;" type="text"></td>
                  </tr>
                  <tr>
                    <td>海流速度</td>
                    <td><input name="fspeed" style="width:60px;" type="text"></td>
                    <td>螺旋桨转速</td>
                    <td><input name="sspeed" style="width:60px;" type="text"></td>
                  </tr>
                  <tr>
                    <td>降雨量</td>
                    <td><input name="rain" style="width:60px;" type="text"></td>
                    <td>中心频率</td>
                    <td><input name="fre" style="width:60px;" type="text"></td>
                  </tr>
                </tbody>
              </table>
              <input type="button" class="btn btn-warning" value="保存数据"
							onClick="autoGetVal('tab7','7','7');">
						<input type="button" class="btn btn-success" value="开始仿真"
							onClick="run('tab7','7','7');">
            </div>
          </div>