<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <style>
        body {
            background-image: url(resources/images/denglu.jpg);
            background-repeat: no-repeat;
            background-size: 100%;
            text-align: center;
            font-family: 'Microsoft YaHei UI';
        }

        table {
            width: 600px;
            height: 300px;
            margin: 15px;
            background-color: gainsboro;
            border-radius: 5px;
        }

        .logindiv {
            width: 630px;
            height: 330px;
            border: 1px solid darkgray;
            border-radius: 20px;
            margin-left: calc(50% - 315px);
        }

        h1 {
            margin-top: 100px;
            color: white;
            letter-spacing: 12px;
            font-size: 40px;
        }

        .loginspan {
            margin-top: 3px;
        }

        td div {
            border: 1px solid black;
            border-radius: 20px;
            background-image: url(resources/images/logos.png);
            background-size: 100%;
            background-color: black;
            width: 130px;
            height: 130px;
            margin-left: 70px;
        }

        tr td:first-child {
            width: 17%;
        }

        td img {
            width: 77%;
        }

        #btnLogin {
            background-color: deepskyblue;
            border-radius: 8px;
            width: 100px;
            height: 30px;
        }

        td > span {
            letter-spacing: 2px;
        }

        input[type=text] {
            -webkit-appearance: none;
            -moz-appearance: none;
            background-color: #fff;
            background-image: none;
            border-radius: 4px;
            border: 1px solid #bfcbd9;
            box-sizing: border-box;
            color: #1f2d3d;
            display: inline-block;
            font-size: inherit;
            height: 30px;
            line-height: 1;
            outline: none;
            padding: 3px 10px;
            transition: border-color .2s cubic-bezier(.645,.045,.355,1);
        }

        #txtCode {
            width: 100px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <h1>核电站焊接管理系统</h1>
        <div class="logindiv">
            <table>
                <tr>
                    <td colspan="3">
<!--                         <img src="../images/-5954500602820014688.png" /> -->
                        <img src="resources/images/gongsilogo.png" />
                    </td>
                </tr>
                <tr>
                    <td rowspan="3">
                        <div>
                        </div>
                    </td>
                    <td>账&nbsp;&nbsp;&nbsp;号:</td>
                    <td style="text-align: left">
                        <asp:TextBox ID="txtAccount" runat="server" autocomplete="off" placeholder="请输入账号..."></asp:TextBox></td>
                </tr>
                <tr>
                    <td>密&nbsp;&nbsp;&nbsp;码:</td>
                    <td style="text-align: left">
                        <asp:TextBox ID="txtPwd" runat="server" autocomplete="off" placeholder="请输入密码..."></asp:TextBox></td>
                </tr>
                <tr>
                    <td>验证码:</td>
                    <td style="text-align: left;">
                        <asp:TextBox ID="txtCode" runat="server"></asp:TextBox></td>
                </tr>
                <tr>
                    <td></td>
                    <td colspan="2">
                        <asp:CheckBox ID="chkLogin" runat="server" /><span>两周内自动登录&nbsp;&nbsp;</span><asp:Button ID="btnLogin" runat="server" Text="登 录" /></td>
                </tr>
            </table>
        </div>
        <span>Copyright ? 1998-2014 某某有限公司</span>
    </form>
</body>
</html>