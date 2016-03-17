<div class="tab-pane" id="tab1B">
    目标三维模型 : <input type="file">
    仿真类型：
    <select name="type1" style="width:90px; height:20px">
      <option value="1">潜艇</option>
      <option value="2">水面舰</option>
      <option value="3">鱼雷</option>
      <option value="4">海洋环境</option>
    </select>
    <select name="type2" style="width:90px; height:20px">
      <option value="1">001</option>
      <option value="2">054A</option>
      <option value="3">039</option>
      <option value="4">鱼7A</option>
      <option value="5">鱼10</option>
    </select>
    <table border="0" cellpadding="1" cellspacing="1" style="width: 100%;">
      <tbody>
        <tr>
          <td>航速/kn</td>
          <td><input name="speed" style="width:75px;" type="text"></td>
          <td>脉宽/ms</td>
          <td><input name="cre" style="width:75px;" type="text"></td>
          <td>发射信号形式：</td>
          <td><select name="type3" style="width:75px;  height:20px">
              <option value="1">CW</option>
              <option value="2">LFM</option>
              <option value="3">HFM</option>
              <option value="4">自定义</option>
            </select></td>
        </tr>
        <tr>
          <td>航向/deg</td>
          <td><input name="ang" style="width:75px;" type="text"></td>
          <td>水平角/˚</td>
          <td><input name="ang2" style="width:75px;" type="text"></td>
          <td>接收波束开角/˚</td>
          <td><input name="ang4" style="width:75px;" type="text"></td>
        </tr>
        <tr>
          <td>中心频率/kHz</td>
          <td><input name="fre" style="width:75px;" type="text"></td>
          <td>周期时间窗口/ms</td>
          <td><input name="time" style="width:75px;" type="text"></td>
          <td>海面谱系数</td>
          <td><select name="type2" style="width:75px;  height:20px">
              <option value="1">矩形</option>
              <option value="2">梯形</option>
            </select></td>
        </tr>
        <tr>
          <td>距离/m：</td>
          <td><input name="distence" style="width:75px;" type="text"></td>
          <td>采样频率/kHz</td>
          <td><input name="cy1" style="width:75px;" type="text"></td>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <td>发射声源级/dB</td>
          <td><input name="ss" style="width:75px;" type="text"></td>
          <td>俯仰角/˚</td>
          <td><input name="ang1" style="width:75px;" type="text"></td>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <td>发射角/˚</td>
          <td><input name="ang3" style="width:75px;" type="text"></td>
          <td>带宽/kHz</td>
          <td><input name="bre" style="width:75px;" type="text"></td>
          <td></td>
          <td></td>
        </tr>
      </tbody>
    </table>
    <input type="button" class="btn btn-warning" value="保存数据"
							onClick="autoGetVal('tab1B',1,'1B');">
	<input type="button" class="btn btn-success" value="开始仿真"
		onClick="run('tab1B',1);">
  </div>