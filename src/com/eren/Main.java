package com.eren;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<Jump> jumps = new ArrayList<>();
        ArrayList<Code> codes = new ArrayList<>();

        try {
            File mipsCode = new File("mips_code.txt");
            Scanner myReader = new Scanner(mipsCode);
            int lineCt = 0;
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                var temp = line.split(" ");
                String op = temp[0];
                if (op.charAt(op.length() - 1) == ':'){
                    String name = op.substring(0, op.length() - 1);
                    jumps.add(new Jump(name, lineCt));
                }
                else{
                    codes.add(new Code(line, lineCt));
                    lineCt++;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for(Code code : codes){
            var temp = code.codeText.split(" ");
            String op = temp[0];
            int rd;
            int rt;
            int rs;
            int shamt;
            int immediate;
            int jump;
            String rdBinary;
            String rsBinary;
            String rtBinary;
            String shamtBinary;
            String immediateBinary;
            String jumpBinary;
            String jumpTo;
            switch (op){
                case "add":
                    code.binaryCode = code.binaryCode.concat("000000");
                    rs = Integer.parseInt(temp[2].substring(1, temp[2].length() - 1));
                    rsBinary = Integer.toBinaryString(rs);
                    while(rsBinary.length() < 5) rsBinary = String.format("0%s", rsBinary);
                    code.binaryCode = code.binaryCode.concat(rsBinary);
                    rt = Integer.parseInt(temp[3].substring(1));
                    rtBinary = Integer.toBinaryString(rt);
                    while(rtBinary.length() < 5) rtBinary = String.format("0%s", rtBinary);
                    code.binaryCode = code.binaryCode.concat(rtBinary);
                    rd = Integer.parseInt(temp[1].substring(1, temp[1].length() - 1));
                    rdBinary = Integer.toBinaryString(rd);
                    while(rdBinary.length() < 5) rdBinary = String.format("0%s", rdBinary);
                    code.binaryCode = code.binaryCode.concat(rdBinary);
                    code.binaryCode = code.binaryCode.concat("00000000000");
                    System.out.println("add done - " + code.binaryCode);
                    break;

                case "sub":
                    code.binaryCode = code.binaryCode.concat("000001");
                    rs = Integer.parseInt(temp[2].substring(1, temp[2].length() - 1));
                    rsBinary = Integer.toBinaryString(rs);
                    while(rsBinary.length() < 5) rsBinary = String.format("0%s", rsBinary);
                    code.binaryCode = code.binaryCode.concat(rsBinary);
                    rt = Integer.parseInt(temp[3].substring(1));
                    rtBinary = Integer.toBinaryString(rt);
                    while(rtBinary.length() < 5) rtBinary = String.format("0%s", rtBinary);
                    code.binaryCode = code.binaryCode.concat(rtBinary);
                    rd = Integer.parseInt(temp[1].substring(1, temp[1].length() - 1));
                    rdBinary = Integer.toBinaryString(rd);
                    while(rdBinary.length() < 5) rdBinary = String.format("0%s", rdBinary);
                    code.binaryCode = code.binaryCode.concat(rdBinary);
                    code.binaryCode = code.binaryCode.concat("00000000000");
                    System.out.println("sub done - " + code.binaryCode);
                    break;

                case "mult":
                    code.binaryCode = code.binaryCode.concat("000010");
                    rs = Integer.parseInt(temp[1].substring(1, temp[1].length() - 1));
                    rsBinary = Integer.toBinaryString(rs);
                    while(rsBinary.length() < 5) rsBinary = String.format("0%s", rsBinary);
                    code.binaryCode = code.binaryCode.concat(rsBinary);
                    rt = Integer.parseInt(temp[2].substring(1));
                    rtBinary = Integer.toBinaryString(rt);
                    while(rtBinary.length() < 5) rtBinary = String.format("0%s", rtBinary);
                    code.binaryCode = code.binaryCode.concat(rtBinary);
                    code.binaryCode = code.binaryCode.concat("0000000000000000");
                    System.out.println("mult done - " + code.binaryCode);
                    break;

                case "and":
                    code.binaryCode = code.binaryCode.concat("000011");
                    rs = Integer.parseInt(temp[2].substring(1, temp[2].length() - 1));
                    rsBinary = Integer.toBinaryString(rs);
                    while(rsBinary.length() < 5) rsBinary = String.format("0%s", rsBinary);
                    code.binaryCode = code.binaryCode.concat(rsBinary);
                    rt = Integer.parseInt(temp[3].substring(1));
                    rtBinary = Integer.toBinaryString(rt);
                    while(rtBinary.length() < 5) rtBinary = String.format("0%s", rtBinary);
                    code.binaryCode = code.binaryCode.concat(rtBinary);
                    rd = Integer.parseInt(temp[1].substring(1, temp[1].length() - 1));
                    rdBinary = Integer.toBinaryString(rd);
                    while(rdBinary.length() < 5) rdBinary = String.format("0%s", rdBinary);
                    code.binaryCode = code.binaryCode.concat(rdBinary);
                    code.binaryCode = code.binaryCode.concat("00000000000");
                    System.out.println("and done - " + code.binaryCode);
                    break;

                case "or":
                    code.binaryCode = code.binaryCode.concat("000100");
                    rs = Integer.parseInt(temp[2].substring(1, temp[2].length() - 1));
                    rsBinary = Integer.toBinaryString(rs);
                    while(rsBinary.length() < 5) rsBinary = String.format("0%s", rsBinary);
                    code.binaryCode = code.binaryCode.concat(rsBinary);
                    rt = Integer.parseInt(temp[3].substring(1));
                    rtBinary = Integer.toBinaryString(rt);
                    while(rtBinary.length() < 5) rtBinary = String.format("0%s", rtBinary);
                    code.binaryCode = code.binaryCode.concat(rtBinary);
                    rd = Integer.parseInt(temp[1].substring(1, temp[1].length() - 1));
                    rdBinary = Integer.toBinaryString(rd);
                    while(rdBinary.length() < 5) rdBinary = String.format("0%s", rdBinary);
                    code.binaryCode = code.binaryCode.concat(rdBinary);
                    code.binaryCode = code.binaryCode.concat("00000000000");
                    System.out.println("or done - " + code.binaryCode);
                    break;

                case "addi":
                    code.binaryCode = code.binaryCode.concat("000101");
                    rs = Integer.parseInt(temp[2].substring(1, temp[2].length() - 1));
                    rsBinary = Integer.toBinaryString(rs);
                    while(rsBinary.length() < 5) rsBinary = String.format("0%s", rsBinary);
                    code.binaryCode = code.binaryCode.concat(rsBinary);
                    
                    rt = Integer.parseInt(temp[1].substring(1, temp[1].length() - 1));
                    rtBinary = Integer.toBinaryString(rt);
                    while(rtBinary.length() < 5) rtBinary = String.format("0%s", rtBinary);
                    code.binaryCode = code.binaryCode.concat(rtBinary);

                    immediate = Integer.parseInt(temp[3]);
                    immediateBinary = Integer.toBinaryString(immediate);
                    if(immediate < 0){
                        code.binaryCode = code.binaryCode.concat(immediateBinary.substring(immediateBinary.length()-16));
                    }else{
                        while(immediateBinary.length() < 16) immediateBinary = String.format("0%s", immediateBinary);
                        code.binaryCode = code.binaryCode.concat(immediateBinary);
                    }
                    System.out.println("addi done - " + code.binaryCode);
                    break;

                case "sll":
                    code.binaryCode = code.binaryCode.concat("000110");
                    rs = Integer.parseInt(temp[2].substring(1, temp[2].length() - 1));
                    rsBinary = Integer.toBinaryString(rs);
                    while(rsBinary.length() < 5) rsBinary = String.format("0%s", rsBinary);
                    code.binaryCode = code.binaryCode.concat(rsBinary);
                    code.binaryCode = code.binaryCode.concat("00000"); //rt
                    rd = Integer.parseInt(temp[1].substring(1, temp[1].length() - 1));
                    rdBinary = Integer.toBinaryString(rd);
                    while(rdBinary.length() < 5) rdBinary = String.format("0%s", rdBinary);
                    code.binaryCode = code.binaryCode.concat(rdBinary);
                    shamt = Integer.parseInt(temp[3]);
                    shamtBinary = Integer.toBinaryString(shamt);
                    while(shamtBinary.length() < 5) shamtBinary = String.format("0%s", shamtBinary);
                    code.binaryCode = code.binaryCode.concat(shamtBinary + "000000");
                    System.out.println("sll done - " + code.binaryCode);
                    break;

                case "slt":
                    code.binaryCode = code.binaryCode.concat("000111");
                    rs = Integer.parseInt(temp[2].substring(1, temp[2].length() - 1));
                    rsBinary = Integer.toBinaryString(rs);
                    while(rsBinary.length() < 5) rsBinary = String.format("0%s", rsBinary);
                    code.binaryCode = code.binaryCode.concat(rsBinary);
                    rt = Integer.parseInt(temp[3].substring(1));
                    rtBinary = Integer.toBinaryString(rt);
                    while(rtBinary.length() < 5) rtBinary = String.format("0%s", rtBinary);
                    code.binaryCode = code.binaryCode.concat(rtBinary);
                    rd = Integer.parseInt(temp[1].substring(1, temp[1].length() - 1));
                    rdBinary = Integer.toBinaryString(rd);
                    while(rdBinary.length() < 5) rdBinary = String.format("0%s", rdBinary);
                    code.binaryCode = code.binaryCode.concat(rdBinary);
                    code.binaryCode = code.binaryCode.concat("00000000000");
                    System.out.println("slt done - " + code.binaryCode);
                    break;

                case "mfhi":
                    code.binaryCode = code.binaryCode.concat("001000");
                    rd = Integer.parseInt(temp[1].substring(1));
                    rdBinary = Integer.toBinaryString(rd);
                    while(rdBinary.length() < 5) rdBinary = String.format("0%s", rdBinary);
                    code.binaryCode = code.binaryCode.concat("0000000000" + rdBinary);
                    code.binaryCode = code.binaryCode.concat("00000000000");
                    System.out.println("mfhi done - " + code.binaryCode);
                    break;

                case "mflo":
                    code.binaryCode = code.binaryCode.concat("001001");
                    rd = Integer.parseInt(temp[1].substring(1));
                    rdBinary = Integer.toBinaryString(rd);
                    while(rdBinary.length() < 5) rdBinary = String.format("0%s", rdBinary);
                    code.binaryCode = code.binaryCode.concat("0000000000" + rdBinary);
                    code.binaryCode = code.binaryCode.concat("00000000000");
                    System.out.println("mflo done - " + code.binaryCode);
                    break;

                case "lw":
                    code.binaryCode = code.binaryCode.concat("001010");
                    int lw = temp[2].indexOf('(');
                    rs = Integer.parseInt(temp[2].substring(lw + 2, temp[2].length() - 1));
                    rsBinary = Integer.toBinaryString(rs);
                    while(rsBinary.length() < 5) rsBinary = String.format("0%s", rsBinary);
                    code.binaryCode = code.binaryCode.concat(rsBinary);

                    rt = Integer.parseInt(temp[1].substring(1, temp[1].length() - 1));
                    rtBinary = Integer.toBinaryString(rt);
                    while(rtBinary.length() < 5) rtBinary = String.format("0%s", rtBinary);
                    code.binaryCode = code.binaryCode.concat(rtBinary);

                    immediate = Integer.parseInt(temp[2].substring(0, lw));
                    immediateBinary = Integer.toBinaryString(immediate);
                    while(immediateBinary.length() < 16) immediateBinary = String.format("0%s", immediateBinary);
                    code.binaryCode = code.binaryCode.concat(immediateBinary);
                    System.out.println("lw done - " + code.binaryCode);
                    break;

                case "sw":
                    code.binaryCode = code.binaryCode.concat("001011");
                    int sw = temp[2].indexOf('(');
                    rs = Integer.parseInt(temp[2].substring(sw + 2, temp[2].length() - 1));
                    rsBinary = Integer.toBinaryString(rs);
                    while(rsBinary.length() < 5) rsBinary = String.format("0%s", rsBinary);
                    code.binaryCode = code.binaryCode.concat(rsBinary);

                    rt = Integer.parseInt(temp[1].substring(1, temp[1].length() - 1));
                    rtBinary = Integer.toBinaryString(rt);
                    while(rtBinary.length() < 5) rtBinary = String.format("0%s", rtBinary);
                    code.binaryCode = code.binaryCode.concat(rtBinary);

                    immediate = Integer.parseInt(temp[2].substring(0, sw));
                    immediateBinary = Integer.toBinaryString(immediate);
                    while(immediateBinary.length() < 16) immediateBinary = String.format("0%s", immediateBinary);
                    code.binaryCode = code.binaryCode.concat(immediateBinary);
                    System.out.println("sw done - " + code.binaryCode);
                    break;

                case "beq":
                    code.binaryCode = code.binaryCode.concat("001100");
                    rs = Integer.parseInt(temp[2].substring(1, temp[2].length() - 1));
                    rsBinary = Integer.toBinaryString(rs);
                    while(rsBinary.length() < 5) rsBinary = String.format("0%s", rsBinary);
                    code.binaryCode = code.binaryCode.concat(rsBinary);

                    rt = Integer.parseInt(temp[1].substring(1, temp[1].length() - 1));
                    rtBinary = Integer.toBinaryString(rt);
                    while(rtBinary.length() < 5) rtBinary = String.format("0%s", rtBinary);
                    code.binaryCode = code.binaryCode.concat(rtBinary);
                    jumpTo = temp[3];
                    for(Jump j : jumps){
                        if(j.name.equals(jumpTo)){
                            immediate = j.address - code.address - 1;
                            immediateBinary = Integer.toBinaryString(immediate);
                            if(immediate < 0){
                                code.binaryCode = code.binaryCode.concat(immediateBinary.substring(immediateBinary.length()-16));
                            }else{
                                while(immediateBinary.length() < 16) immediateBinary = String.format("0%s", immediateBinary);
                                code.binaryCode = code.binaryCode.concat(immediateBinary);
                            }
                        }
                    }
                    System.out.println("beq done - " + code.binaryCode);
                    break;

                case "blez":
                    code.binaryCode = code.binaryCode.concat("001101");
                    rs = Integer.parseInt(temp[1].substring(1, temp[1].length() - 1));
                    rsBinary = Integer.toBinaryString(rs);
                    while(rsBinary.length() < 5) rsBinary = String.format("0%s", rsBinary);
                    code.binaryCode = code.binaryCode.concat(rsBinary);
                    code.binaryCode = code.binaryCode.concat("00000");
                    jumpTo = temp[2];
                    for(Jump j : jumps){
                        if(j.name.equals(jumpTo)){
                            immediate = j.address - code.address - 1;
                            immediateBinary = Integer.toBinaryString(immediate);
                            if(immediate < 0){
                                code.binaryCode = code.binaryCode.concat(immediateBinary.substring(immediateBinary.length()-16));
                            }else{
                                while(immediateBinary.length() < 16) immediateBinary = String.format("0%s", immediateBinary);
                                code.binaryCode = code.binaryCode.concat(immediateBinary);
                            }
                        }
                    }
                    System.out.println("blez done - " + code.binaryCode);
                    break;

                case "j":
                    code.binaryCode = code.binaryCode.concat("001110");
                    jumpTo = temp[1];
                    for(Jump j : jumps){
                        if(j.name.equals(jumpTo)){
                            jump = j.address - code.address - 1;
                            jumpBinary = Integer.toBinaryString(jump);
                            if(jump < 0){
                                code.binaryCode = code.binaryCode.concat(jumpBinary.substring(jumpBinary.length()-26));
                            }else{
                                while(jumpBinary.length() < 26) jumpBinary = String.format("0%s", jumpBinary);
                                code.binaryCode = code.binaryCode.concat(jumpBinary);
                            }

                        }
                    }
                    System.out.println("jump done - " + code.binaryCode);
                    break;

                case "clear":
                    code.binaryCode = code.binaryCode.concat("0011110000000000");
                    if(temp[1].equals("all")){
                        code.binaryCode = code.binaryCode.concat("1111111111111111");
                    }else{
                        immediate = Integer.parseInt(temp[1]);
                        immediateBinary = Integer.toBinaryString(immediate);
                        if(immediate < 0){
                            code.binaryCode = code.binaryCode.concat(immediateBinary.substring(immediateBinary.length()-16));
                        }else{
                            while(immediateBinary.length() < 16) immediateBinary = String.format("0%s", immediateBinary);
                            code.binaryCode = code.binaryCode.concat(immediateBinary);
                        }
                    }

                    System.out.println("clear done - " + code.binaryCode);
                    break;

                case "nop":
                    code.binaryCode = code.binaryCode.concat("0111110000000000");
                    code.binaryCode = code.binaryCode.concat("0000000000000000");
                    System.out.println("nop done - " + code.binaryCode);
                    break;
            }

        }



        for(Jump jump : jumps){
            System.out.println(jump.name + " " + jump.address);
        }
        System.out.println("----");
        for(Code code : codes){
            System.out.println(code.codeText + " " + code.address);
        }
        System.out.println("----");
        try {
            File myObj = new File("machine_code.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            FileWriter writer = new FileWriter("machine_code.txt");
            writer.write("v2.0 raw\n");
            for(Code code :  codes){
                int decimal = Integer.parseInt(code.binaryCode,2);
                code.hexCode = Integer.toString(decimal,16);
                while(code.hexCode.length() < 8) code.hexCode = String.format("0%s", code.hexCode);
                writer.write(code.hexCode + "\n");
                System.out.println(code.binaryCode + " -- " +code.hexCode);
            }
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for(Code code :  codes){
            int decimal = Integer.parseInt(code.binaryCode,2);
            code.hexCode = Integer.toString(decimal,16);
            while(code.hexCode.length() < 8) code.hexCode = String.format("0%s", code.hexCode);

            System.out.println(code.binaryCode + " -- " +code.hexCode);
        }

    }
}

class Jump {
    String name;
    int address;

    Jump(String name, int address) {
        this.name = name;
        this.address = address;
    }
}

class Code {
    String codeText;
    int address;
    String binaryCode = "";
    String hexCode = "";

    Code(String codeText, int address) {
        this.codeText = codeText;
        this.address = address;
    }
}
