package ru.sgs.fireman.utlis;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class Version {

    private FileHandle fileHandle = Gdx.files.internal("Version");
    private String[] subString;
    private String version;
    private String subversion;

    private FileHandle README = Gdx.files.local("/../../README.md");
    private String[] subStringReadme;


    public Version(){
        subString = fileHandle.readString().split("\\R");

        version = subString[0];
        subversion = subString[1];
    }

    public void writeVersion(){
        subStringReadme = README.readString().split("\\R");

        for (int i=0; i<subStringReadme.length; i++){
            if(i==0){
                String str = "# FireMan [![Build Status](https://img.shields.io/badge/Version-" + version;

                if (subversion.equals("Alpha"))
                    str += "-red.svg";
                else if (subversion.equals("Beta"))
                    str += "-orange.svg";
                else
                    str += "-green.svg";

                str += ")](#FireMan)";

                subStringReadme[0] = str;
            }
        }

        for (int i=0; i<subStringReadme.length; i++){
            if (i == 0)
                README.writeString(subStringReadme[i], false);
            else
                README.writeString(subStringReadme[i], true);

            README.writeString("\n", true);
        }
    }

    public String getVersion(){
        return version;
    }

    public String getSubversion(){
        return subversion;
    }
}
