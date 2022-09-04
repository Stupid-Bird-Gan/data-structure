package com.gllstu.huffmancode;

import java.io.*;
import java.util.*;

/**
 * @author LinJun
 * @version 1.0
 */
public class HuffmanCode {
    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
        byte[] bytes = str.getBytes();
        byte[] zip = huffmanZip(bytes);
        System.out.println(Arrays.toString(zip));
        byte[] decode = decode(huffmanCodes, zip);
        System.out.println(new String(decode));
    }
    public static List<Node> getNodes(byte[] bytes){
        ArrayList<Node> list = new ArrayList<>();
        //存储每个byte出现的次数
        HashMap<Byte, Integer> map = new HashMap<>();
        for (byte b:bytes){
            Integer count = map.get(b);
            if (count==null){
                map.put(b,1);
            }else {
                map.put(b,count+1);
            }
        }
        for (Map.Entry<Byte,Integer> entry:map.entrySet()){
            list.add(new Node(entry.getKey(),entry.getValue()));
        }
        return list;
    }
    //通过List创建哈夫曼树
    public static Node createHuffmanTree(List<Node> list){
        while (list.size()>1){
            Collections.sort(list);
            Node left = list.get(0);
            Node right = list.get(1);
            Node parent = new Node(null, left.weight + right.weight);
            parent.left=left;
            parent.right=right;
            list.remove(left);
            list.remove(right);
            list.add(parent);

        }
        return list.get(0);
    }
    public static void preOrder(Node root){
        if (root!=null){
            root.preOrder();
        }else {
            System.out.println("null");
        }
    }
    //在生成哈夫曼编码时，需要去拼接路劲，定义一个StringBuilder，存储某个叶子结点的路径
    static Map<Byte,String> huffmanCodes = new HashMap<Byte,String>();
    static StringBuilder  stringBuilder= new StringBuilder();
    public static void getCodes(Node node,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder2= new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if (node!=null){
            //判断node是否是叶子jiedian
            if (node.date==null){
                getCodes(node.left,"0",stringBuilder2);
                getCodes(node.right,"1",stringBuilder2);
            }else {
                //表示找到叶子结点
                huffmanCodes.put(node.date,stringBuilder2.toString());
            }
        }
    }
    //编写一个方法，将字符窜对应的的byte[]数组，通过生成的哈夫曼编码表，返回一个哈夫曼编码压缩后的byte[]数组
    public static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes){
        //1.利用huffmanCodes 将bytes 转成哈夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b:bytes){
            stringBuilder.append(huffmanCodes.get(b));
        }
        //2.将得到的stringBuilder转成byte数组,八位转成一个byte，这里是补码
        int length;
        if (stringBuilder.length()%8==0){
            length=stringBuilder.length()/8;
        }else {
            length=stringBuilder.length()/8+1;
        }
        //创建存储后的byte数组
        byte[] by = new byte[length];
        int index=0;//记录是第几个byte
        for (int i=0;i<stringBuilder.length();i+=8){
            String strByte;
            if (i+8>stringBuilder.length()) {
                strByte = stringBuilder.substring(i);
            }else {
                strByte=stringBuilder.substring(i,i+8);
            }
            by[index++]=(byte) Integer.parseInt(strByte,2);
        }
        return by;
    }
    public static byte[] huffmanZip(byte[] bytes){
        List<Node> list = getNodes(bytes);
        Node huffmanTree = createHuffmanTree(list);
        //生成对应的哈夫曼编码
        getCodes(huffmanTree,"",stringBuilder);
        byte[] huffmanCodeBytes = zip(bytes,huffmanCodes);
        return huffmanCodeBytes;
    }
    public static String byteToBitString(boolean flag,byte b){
        int temp=b;
        //如果变量是正数还存在补高位
        if (flag){
            temp|=256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        }else {
            return str;
        }
    }
    public static byte[] decode(Map<Byte,String> huffmanCodes,byte[] bytes){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i< bytes.length;i++){
            if (i==bytes.length-1){
                String s = byteToBitString(false, bytes[i]);
                stringBuilder.append(s);
            }else {
                String s = byteToBitString(true, bytes[i]);
                stringBuilder.append(s);
            }
        }
        Map<String,Byte> map = new HashMap<>();
        for (Map.Entry<Byte,String> entry:huffmanCodes.entrySet()){
            map.put(entry.getValue(), entry.getKey());
        }
        ArrayList<Byte> list = new ArrayList<>();
        for (int i=0;i<stringBuilder.length();){
            int count=1;
            boolean flag=true;
            Byte b =null;
            while (flag){
                String key = stringBuilder.substring(i,i+count);
                b=map.get(key);
                if (b==null){
                    count++;
                }else {
                    flag=false;
                }
            }
            list.add(b);
            i+=count;
        }
        byte b[] = new byte[list.size()];
        for (int i=0;i<b.length;i++){
            b[i]=list.get(i);
        }
        return b;
    }
    //将一个文件压缩

    /**
     *
     * @param srcFile 希望压缩的源文件
     * @param desFile 将压缩文件放到哪个目录
     */
    public static void zipFile(String srcFile,String desFile) throws IOException {
        //创建一个文件输入流
        FileInputStream fileInputStream=null;
        FileOutputStream fileOutputStream=null;
        ObjectOutputStream objectOutputStream=null;
        try {
            fileInputStream = new FileInputStream(srcFile);
            byte[] bytes = new byte[fileInputStream.available()];
            //读取文件
            fileInputStream.read(bytes);
            byte[] huffmanZip = huffmanZip(bytes);
            //获取到了源文件的哈夫曼压缩
            fileOutputStream = new FileOutputStream(desFile);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(huffmanZip);
            objectOutputStream.writeObject(huffmanCodes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileInputStream.close();
            fileOutputStream.close();
            objectOutputStream.close();
        }
    }

    /**
     *
     * @param zipFile 准备解压的文件
     * @param dstFile 存放解压后文件的路径
     */
    public static void unZipFile(String zipFile,String dstFile) throws IOException, ClassNotFoundException {
        InputStream inputStream=null;
        ObjectInputStream objectInputStream = null;
        OutputStream outputStream=null;
        try {
            inputStream = new FileInputStream(zipFile);
            objectInputStream = new ObjectInputStream(inputStream);
            byte[] b= (byte[])objectInputStream.readObject();
            Map<Byte,String> map = (Map<Byte,String>)objectInputStream.readObject();
            //解码
            byte[] decode = decode(map, b);
            outputStream = new FileOutputStream(dstFile);
            outputStream.write(b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            objectInputStream.close();
            inputStream.close();
            outputStream.close();
        }
    }
}
class Node implements Comparable<Node>{
    Byte date;
    int weight;
    Node left;
    Node right;
    public Node(Byte data,int weight){
        this.date=data;
        this.weight=weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight-o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "date=" + date +
                ", weight=" + weight +
                '}';
    }
    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }
}