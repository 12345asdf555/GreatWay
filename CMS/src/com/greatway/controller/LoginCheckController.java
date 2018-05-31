package com.greatway.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/logincheck",produces="text/json;charset=UTF-8")
public class LoginCheckController {
	//图片高度
	private static final int IMG_HEIGHT = 100;
	//图片宽度
	private static final int IMG_WIDTH = 30;
	//验证码长度
	private static final int CODE_LEN = 4;
	
	@RequestMapping("/checkImg")
	public void checkImg(HttpServletRequest request,HttpServletResponse response){
		try {
			//用于绘制图片，设置图片长宽及类型（RGB）
			BufferedImage bi = new BufferedImage(IMG_HEIGHT, IMG_WIDTH, CODE_LEN);
			//获取绘图工具
			Graphics graphics = bi.getGraphics();
			graphics.setColor(new Color(100, 230, 200));
			graphics.fillRect(0, 0, 100, 30);//填充矩形区域
			
			//验证码所用到的字符
			char[] codeChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
			String captcha = "";//存放生成的验证码
			Random random = new Random();
			for(int i=0; i<CODE_LEN; i++){//将验证码绘制到图片上
				int index = random.nextInt(codeChar.length);
				//随机生成验证码的颜色
				graphics.setColor(new Color(random.nextInt(150), random.nextInt(200), random.nextInt(255)));
				//设置字体，样式，大小
				graphics.setFont(new Font("楷体", Font.BOLD, 18));
				//将一个字符绘制到图片上，并制定位置（xy坐标）
				graphics.drawString(codeChar[index] + "", (i*20)+15, 20);
				captcha += codeChar[index];
			}
			//将生成的验证码code放入session中
			request.getSession().setAttribute("code", captcha);
			//通过ImageIO将图片输出
			ImageIO.write(bi, "JPG", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
