<div class="tab-pane" id="tab1">
    目标三维模型 : <input type="file"><br>
    仿真类型：
    <select name="type1" style="width:90px; height:20px">
      <option value="1">海洋环境</option>
      <option value="2">潜艇</option>
      <option value="3">水面舰</option>
      <option value="4">鱼类</option>
    </select>
    <select name="type2" style="width:90px; height:20px">
      <option value="1">001</option>
      <option value="2">054A</option>
      <option value="3">039</option>
      <option value="4">鱼－7A</option>
      <option value="5">鱼－10</option>
    </select>
    <table border="0" cellpadding="1" cellspacing="1" style="width: 100%;">
      <tbody>
        <tr>
          <td>采样频率KHz：</td>
          <td><input name="speed" style="width:75px;" type="text"></td>
          <td>检测域dB：</td>
          <td><input name="bre" style="width:75px;" type="text"></td>
          <td>距离：</td>
          <td><input name="ang1" style="width:75px;" type="text"></td>
        </tr>
        <tr>
          <td>声速m/s：</td>
          <td><input name="ang" style="width:75px;" type="text"></td>
          <td>仿真总时间：</td>
          <td><input name="cre" style="width:75px;" type="text"></td>
          <td>发射信号形式：</td>
          <td><select name="type3" style="width:75px;  height:20px">
		      <option value="1">CW</option>
              <option value="2">LFM</option>
              <option value="3">其他</option>
		    </select></td>
        </tr>
        <tr>
          <td>声源级dB：</td>
          <td><input name="fre" style="width:75px;" type="text"></td>
          <td>仿真开始时刻：</td>
          <td><input name="distence" style="width:75px;" type="text"></td>
          <td></td>
          <td></td>
        </tr>
      </tbody>
    </table>
    <input type="button" class="btn btn-warning" value="保存数据"
							onClick="autoGetVal('tab1',1);">
						<input type="button" class="btn btn-success" value="开始仿真"
							onClick="showData('tab1');">
  </div>