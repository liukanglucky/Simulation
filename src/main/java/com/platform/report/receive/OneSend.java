package com.platform.report.receive;

import java.io.Serializable;
import java.lang.reflect.Field;
/**
 * 舰艇目标反射模型
 * @author liukang
 *
 */
public class OneSend implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6029171754623813731L;
	
	private char memo;
	private float hs;
	private float hx;
	private float zxpl;
	private float dk;
	private float mk;
	private float mbzxjl;
	private float mbfyztj;
	private float mbspztj;
	private float cfzqsjck;
	private float cypl;
	private float fssyj;
	private float fsbskj;
	private char fzlx;
	private char bl;
	private char fsxhxs;
	private char wjmcd;
	private char[] wjm;
	
	
	public OneSend(char memo,float hs,float hx,float zxpl,float dk,float mk,float mbzxjl,
			float mbfyztj,float mbspztj,float cfzqsjck,float cypl,float fssyj,float fsbskj,
			char fzlx,char bl,char fsxhxs,char wjmcd,char[] wjm) {
		this.memo = memo;
		this.hs = hs;
		this.hx = hx;
		this.zxpl = zxpl;
		this.dk = dk;
		this.mk = mk;
		this.mbzxjl = mbzxjl;
		this.mbfyztj = mbfyztj;
		this.mbspztj = mbspztj;
		this.cfzqsjck = cfzqsjck;
		this.cypl = cypl;
		this.fssyj = fssyj;
		this.fsbskj = fsbskj;
		this.fzlx = fzlx;
		this.bl = bl;
		this.fsxhxs = fsxhxs;
		this.wjmcd = wjmcd;
		this.wjm = wjm;
	}
	
	public OneSend() {
		// TODO Auto-generated constructor stub
	}
	
	public String toString(){
		String ret = null;
		ret += String.valueOf(memo);
		return ret;
	} 

	public static void main(String[] args) {
		char[] wjm = {'0','1'};
		OneSend oneSend = new OneSend('a', (float)0,(float)0, (float)0, (float)0, (float)0, (float)0, (float)0, (float)0, (float)0, (float)0, (float)0, (float)0, '1', '2', 'z', '5',wjm);
		System.out.println(oneSend.toString());
	}
}
