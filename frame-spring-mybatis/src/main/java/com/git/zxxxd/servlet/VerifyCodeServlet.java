package com.git.zxxxd.servlet;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class VerifyCodeServlet extends HttpServlet {

    private ApplicationContext applicationContext;

    private static final long serialVersionUID = 1L;

    // 验证码图片的宽度。
    private int width = 120;

    // 验证码图片的高度。
    private int height = 40;

    // 验证码字符个数
    private int codeCount = 4;

    private int x = 0;

    // 字体高度
    private int fontHeight;

    private int codeY;
    
    /**
     * 初始化验证图片属性  ，从web.xml中获得
     */
    public void init() throws ServletException {
//        applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());

        // 宽度
        String sWidth = this.getInitParameter("width");
        // 高度
        String sHeight = this.getInitParameter("height");
        // 字符个数
        String sCodeCount = this.getInitParameter("codeCount");

        //将配置的信息转换成数值
        try {
            if (sWidth != null && sWidth.length() != 0) {
                width = Integer.parseInt(sWidth);
            }
            if (sHeight != null && sHeight.length() != 0) {
                height = Integer.parseInt(sHeight);
            }
            if (sCodeCount != null && sCodeCount.length() != 0) {
                codeCount = Integer.parseInt(sCodeCount);
            }
        } catch (NumberFormatException e) {
        }

        x = width / (codeCount + 1) + 1;
        fontHeight = height - 2;
        codeY = height - 5;

    }

    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, java.io.IOException {
//        String verId = req.getParameter("uid");
//        if (isBlank(verId)) {
//            return;
//        }
        // 定义图像buffer
        BufferedImage buffImg = new BufferedImage(width + 10, height + 5,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g = buffImg.createGraphics();

        // 创建一个随机数生成器类
        Random random = new Random();

        // 将图像填充为白色
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width + 10, height + 5);

        // 创建字体，字体的大小应该根据图片的高度来定。
        Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);
        // 设置字体。
        g.setFont(font);

        // 画边框。
        g.setColor(Color.WHITE);
        g.drawRect(0, 0, width + 10, height + 5);

        // 随机产生180条干扰线，使图象中的认证码不易被其它程序探测到。
        g.setColor(Color.BLACK);
		for (int i = 0; i < 180; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}

        // randomCode用于保存随机产生的验证码
        StringBuffer randomCode = new StringBuffer();
        @SuppressWarnings("unused")
        int red = 0, green = 0, blue = 0;

        // 随机产生codeCount数字的验证码。字，字母，颜色都是随机分配的
        for (int i = 0; i < codeCount; i++) {
            String strRand = "";
            strRand = getRandomCharAndNum(1, true);
            // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);

            // 用随机产生的颜色将验证码绘制到图像中。
            g.setColor(new Color(red, green, blue));
			g.setColor(Color.BLACK);
			g.drawString(strRand, (i) * x, codeY);

            // 将产生的四个随机数组合在一起。
            randomCode.append(strRand);
        }
        //如果验证码为纯数字，则随机替换其中一个数位的数字为字母
        boolean isnumber = isInteger(randomCode.toString());
        if (isnumber == true) {
            int num = random.nextInt(codeCount);
            String str = getRandomCharAndNum(1, false);
            randomCode.replace(num, num + 1, str);
        }
        randomCode = replaceSpecialLetters(randomCode);
        //生成图形验证码
        g.setColor(Color.BLACK);
        g.drawString(randomCode.toString(), 0, codeY);
		/*// 将四位数字的验证码保存到Session中,也可以放到request中
		HttpSession session = req.getSession();
		session.setAttribute("validateCode", randomCode.toString());
		session.setMaxInactiveInterval(120);*/
        if (true) {
//            boolean isSetSuccess = RedisUtil.setString(verId, randomCode.toString(), 180);
//            boolean isSetSamSuccess = SamRedisUtil.setString(verId, randomCode.toString(), 180);  //用于登录校验
//            if (!isSetSuccess || !isSetSamSuccess) {
//                return;
//            }
//        } else {
//            String authId = OCSUtil.INSTANCE.Add(verId, randomCode.toString(), 180);
//            if ("".equals(authId)) {
//                return;
//            }
        }
        // 禁止图像缓存。
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);

        resp.setContentType("image/jpeg");

        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos = resp.getOutputStream();
        ImageIO.write(buffImg, "jpeg", sos);
        sos.close();
    }

    /**
     * @param length
     * @return
     * @author xiahaoran
     */
    public static String getRandomCharAndNum(Integer length, boolean q) {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        int randMint = 65 + random.nextInt(25);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (randMint == 105 || randMint == 73 || randMint == 79 || randMint == 111 || randMint == 108 || randMint == 76) {
                randMint = 65 + random.nextInt(25);
            } else {
                break;
            }
        }
        if (q == false) {
            boolean c = random.nextBoolean();
            if (c) {
                str.append(Character.toUpperCase((char) randMint));
            } else {
                str.append(Character.toLowerCase((char) randMint));
            }
            return str.toString();
        } else {
            for (int i = 0; i < length; i++) {
                boolean b = random.nextBoolean();
                if (b) {
                    str.append(String.valueOf(random.nextInt(10)));
                } else {
                    boolean c = random.nextBoolean();
                    if (c) {
                        str.append( Character.toUpperCase((char) randMint));
                    } else {
                        str.append(Character.toLowerCase((char) randMint));
                    }
                }
            }
            return str.toString();
        }

    }

    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }
    private static final String needReplaceLetters[] = {"0","o","O","1","I","i","l","L"}; //需要替换的字符串
    private static final String[] canShowLetters = {"A","B","C","D","E","F","G","H","J","K","M","N","P","R","S","T","U","V","W","X","Y","Z",
            "a","b","c","d","e","f","g","h","j","k","m","n","p","r","s","t","u","v","w","x","y","z","2","3","4","5","6","8"};  //可以展示的字符

    public StringBuffer replaceSpecialLetters(StringBuffer randomCodeBuffer) {
        String randomCode = randomCodeBuffer.toString();
        Random random = new Random();
        for (String letter : needReplaceLetters) {
            if(randomCode.contains(letter)) {
                randomCode = randomCode.replace(letter, canShowLetters[random.nextInt(canShowLetters.length)]);
            }
        }
        return new StringBuffer(randomCode);
    }

}