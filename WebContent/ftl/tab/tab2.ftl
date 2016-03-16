<div class="tab-pane" id="tab2">
    <div margin:0 auto>
      请输入模型类型：
       <select name="type1" style="width:100px;  height:20px">
                <option value="1">海洋环境</option>
                <option value="2">潜艇</option>
                <option value="3">水面舰</option>
                <option value="4">鱼雷</option>
        </select>
    </div>
    <table border="0" cellpadding="1" cellspacing="1" style="width: 100%; font-size:8px;">
      <tr>
        <td>纵波声速</td>
        <td><input name="speed1" style="width:75px;" type="text" value=tab2_data.speed1></td>
        <td>海底谱强度</td>
        <td><input name="pu1" style="width:75px;" type="text"></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>信号形式1</td>
        <td><select name="type2" style="width:75px;  height:20px">
				  <option value="1">CW</option>
	              <option value="2">HFM</option>
	              <option value="3">LFM</option>
	              <option value="4">自定义</option>
			</select></td>
      </tr>
      <tr>
        <td>横波声速</td>
        <td><input name="speed2" style="width:75px;" type="text"></td>
        <td>海底谱系数</td>
        <td><input name="pu2" style="width:75px;" type="text"></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>信号形式2</td>
        <td><select name="type2" style="width:75px;  height:20px">
				  <option value="1">CW</option>
	              <option value="2">HFM</option>
	              <option value="3">LFM</option>
	              <option value="4">自定义</option>
			</select></td>
      </tr>
      <tr>
        <td>介质密度</td>
        <td><input name="jz" style="width:75px;" type="text"></td>
        <td>风速m/s</td>
        <td><input name="wind" style="width:75px;" type="text"></td>
        <td><input name="wind" style="width:75px;" type="text"></td>
        <td><input name="wind" style="width:75px;" type="text"></td>
        <td></td>
        <td>信号形式3</td>
        <td><select name="type2" style="width:75px;  height:20px">
				  <option value="1">CW</option>
	              <option value="2">HFM</option>
	              <option value="3">LFM</option>
	              <option value="4">自定义</option>
			</select></td>
      </tr>
      <tr>
        <td>海底散射点</td>
        <td><input name="num1" style="width:75px;" type="text"></td>
        <td>海流速度m/s</td>
        <td><input name="fspeed" style="width:75px;" type="text"></td>
        <td><input name="fspeed" style="width:75px;" type="text"></td>
        <td><input name="fspeed" style="width:75px;" type="text"></td>
        <td></td>
        <td>信号形式4</td>
        <td><select name="type2" style="width:75px;  height:20px">
				  <option value="1">CW</option>
	              <option value="2">HFM</option>
	              <option value="3">LFM</option>
	              <option value="4">自定义</option>
			</select></td>
      </tr>
      <tr>
        <td>海水深度m</td>
        <td><input name="depth" style="width:75px;" type="text"></td>
        <td>横波衰弱系数</td>
        <td><input name="d2" style="width:75px;" type="text"></td>
        <td><input name="d2" style="width:75px;" type="text"></td>
        <td><input name="d2" style="width:75px;" type="text"></td>
        <td><input name="d2" style="width:75px;" type="text"></td>
        <td>海面散射点</td>
        <td><input name="num2" style="width:75px;" type="text"></td>
      </tr>
      <tr>
        <td>声速m/s</td>
        <td><input name="speed3" style="width:75px;" type="text"></td>
        <td>纵波衰弱系数</td>
        <td><input name="d1" style="width:75px;" type="text"></td>
        <td><input name="d1" style="width:75px;" type="text"></td>
        <td><input name="d1" style="width:75px;" type="text"></td>
        <td><input name="d1" style="width:75px;" type="text"></td>
        <td>水平角1</td>
        <td><input name="ang1" style="width:75px;" type="text"></td>
      </tr>
      <tr>
        <td>海面谱系数</td>
        <td><input name="pu3" style="width:75px;" type="text"></td>
        <td>声波衰弱系数</td>
        <td><input name="d3" style="width:75px;" type="text"></td>
        <td><input name="d3" style="width:75px;" type="text"></td>
        <td><input name="d3" style="width:75px;" type="text"></td>
        <td><input name="d3" style="width:75px;" type="text"></td>
        <td>水平角2</td>
        <td><input name="ang1" style="width:75px;" type="text"></td>
      </tr>
      <tr>
        <td>垂直角1</td>
        <td><input name="ang2" style="width:75px;" type="text"></td>
        <td>垂直角2</td>
        <td><input name="ang2" style="width:75px;" type="text"></td>
        <td>&nbsp;</td>
        <td>方位角1</td>
        <td><input name="ang3" style="width:75px;" type="text"></td>
        <td>水平角3</td>
        <td><input name="ang3" style="width:75px;" type="text"></td>
      </tr>
    </table>

    <div class="span2">阵元位置m</div>
    <div class="span8">
      <table border="0" cellpadding="1" cellspacing="1" style="width: 100%;">
        <tbody>
          <tr>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
          </tr>
          <tr>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
          </tr>
          <tr>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
          </tr>
          <tr>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
          </tr>
          <tr>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
          </tr>
          <tr>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
          </tr>
        </tbody>
      </table>
    </div>
    <div class="span2">
      请按照纵向XYZ顺序填写每个阵元的位置
    </div>
    <div class="span7">
      <table border="0" cellpadding="1" cellspacing="1" style="width: 100%;">
        <tbody>
          <tr>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
          </tr>
          <tr>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
          </tr>
          <tr>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
          </tr>
          <tr>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
          </tr>
          <tr>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
          </tr>
          <tr>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
            <td><input name="slocx" style="width:40px;" type="text"></td>
          </tr>
        </tbody>
      </table>
    </div>
    <table border="0" cellpadding="1" cellspacing="1" style="width: 100%; font-size:8px;">
      <tr>
        <td>俯仰角1</td>
        <td><input name="ang4" style="width:60px;" type="text"></td>
        <td>采样率Hz</td>
        <td><input name="cy1" style="width:60px;" type="text"></td>
        <td>带宽Hz</td>
        <td><input name="dk1" style="width:60px;" type="text"></td>
        <td><input name="dk1" style="width:60px;" type="text"></td>
        <td><input name="dk1" style="width:60px;" type="text"></td>
        <td><input name="dk1" style="width:60px;" type="text"></td>
      </tr>
      <tr>
        <td>俯仰角2</td>
        <td><input name="ang4" style="width:60px;" type="text"></td>
        <td>脉宽ms</td>
        <td><input name="mk1" style="width:60px;" type="text"></td>
        <td>中心频率Hz</td>
        <td><input name="fre1" style="width:60px;" type="text"></td>
        <td><input name="fre1" style="width:60px;" type="text"></td>
        <td><input name="fre1" style="width:60px;" type="text"></td>
        <td><input name="fre1" style="width:60px;" type="text"></td>
      </tr>
      <tr>
        <td>声源级dB</td>
        <td><input name="ss" style="width:60px;" type="text"></td>
        <td>阵元数</td>
        <td><input name="num" style="width:60px;" type="text"></td>
        <td>声源位置m</td>
        <td><input name="loc" style="width:60px;" type="text"></td>
        <td><input name="loc" style="width:60px;" type="text"></td>
        <td><input name="loc" style="width:60px;" type="text"></td>
        <td></td>
      </tr>
      <tr>
        <td>海面谱指数</td>
        <td><input name="pu4" style="width:60px;" type="text"></td>
        <td>灵敏度dB</td>
        <td><input name="lm1" style="width:60px;" type="text"></td>
        <td>声源速度m/s</td>
        <td><input name="speed" style="width:60px;" type="text"></td>
        <td><input name="speed" style="width:60px;" type="text"></td>
        <td><input name="speed" style="width:60px;" type="text"></td>
        <td></td>
      </tr>
      </table>
     <input type="button" class="btn btn-warning" value="保存数据"
							onClick="autoGetVal('tab2',2,2);">
	<input type="button" class="btn btn-success" value="开始仿真"
		onClick="run('tab2',2);">
  </div>