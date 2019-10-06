package com.company;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/*
1.	Поверить соответствие строки формату IP-адреса v6.
2.	В тексте найти все строки со значением IP-адреса v6 и заменить его элементы на числа в 16 системе счисления. (???)
P.s. буду переводить в восьмеричную
*/
public class Regular {
    Pattern pattern = Pattern.compile("[0-9a-f]{1,4}+:[0-9a-f]{1,4}+:[0-9a-f]{1,4}+:[0-9a-f]{1,4}+:[0-9a-f]{1,4}+:[0-9a-f]{1,4}+:[0-9a-f]{1,4}+:[0-9a-f]{1,4}");
    String text;
    String eight;
    Regular(String text){
        this.text = text;
    }
    public boolean isIPV6(){
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public String replace(){
        Matcher matcher = pattern.matcher(text);
        String[] Sixteen;
        String[] withoutIP = pattern.split(text);
        StringBuilder result;
        eight = text;

        int count = 0;
        while(matcher.find()) {
            String IP = matcher.group();
            Sixteen = IP.split(":");

            StringBuilder ip = new StringBuilder();
            int num;

            for(int i = 0; i<7; i++){
                Sixteen[i] = "0x"+Sixteen[i];
                num = Integer.decode(Sixteen[i]);
                //System.out.println(num);
                String convert = Integer.toOctalString(num);
                ip.append(convert).append(":");
            }
            Sixteen[7] = "0x"+Sixteen[7];
            num = Integer.decode(Sixteen[7]);
            //System.out.println(num);
            String convert = Integer.toOctalString(num);
            ip.append(convert);
            eight = eight.replaceAll(IP, ip.toString());
        }

        return eight;
    }
}
