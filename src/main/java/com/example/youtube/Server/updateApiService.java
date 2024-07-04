package com.example.youtube.Server;
import com.example.youtube.Model.*;
import com.example.youtube.DataBase.*;

import com.google.gson.Gson;
public class updateApiService {
    private static final Gson gson = new Gson();
    public static String handleRequest(String request) {
        String[] parts = request.split("#", 2);
        String endpoint = parts[0];
        String body = parts.length > 1 ? parts[1] : "";

        switch (endpoint) {
            case "31":
                return deleteVideo(body); // video?
            case "32":
                return deletePalylist(body); // image?
            case "33":
                return deleteComment(body);
            case "34":
                return unfollow(body);
            default:
                return gson.toJson(new deleteApiService.ErrorResponse("Unknown endpoint"));
        }
    }
    //to change password
    private static String editPassword(String userInfo) {
        try {
            String[] info=userInfo.split("#",2);
            if(DataBaseManager.CH_PassWordUser(info[0],info[1])) {
                //If the changes are applied successfully, return 1
                return "1";
            }
            return "0";
        }catch (Exception e){
            //if wasn't successfully, return 0
            return "0";
        }
    }
    //to change username
    private static String editUsername(String userInfo) {
        try {
            String[] info=userInfo.split("#",2);
            if(DataBaseManager.CH_UserName(info[0],info[1])) {
                //If the changes are applied successfully, return 1
                return "1";
            }
            return "0";
        }catch (Exception e){
            //if wasn't successfully, return 0
            return "0";
        }
    }
    // edit name of playlist
    private static String editNameOfPlayList(String playlistInfo) {
        try {
            String[] info=playlistInfo.split("#",2);
            if(DataBaseManager.UP_Name_Playlist(info[0],info[1])) {
                //If the changes are applied successfully, return 1
                return "1";
            }
            return "0";
        }catch (Exception e){
            //if wasn't successfully, return 0
            return "0";
        }
    }
    // to like a comment
    private static String updateLikeComment(String commentInfo) {
        try {
            if(DataBaseManager.UP_Like_Comment(commentInfo)) {
                //If the changes are applied successfully, return 1
                return "1";
            }
            return "0";
        }catch (Exception e){
            //if wasn't successfully, return 0
            return "0";
        }
    }
    // to edit a comment text
    private static String updateTextComment(String commentInfo) {
        try {
            String[] info=commentInfo.split("#",2);
            if(DataBaseManager.UP_Text_Comment(info[0],info[1])) {
                //If the changes are applied successfully, return 1
                return "1";
            }
            return "0";
        }catch (Exception e){
            //if wasn't successfully, return 0
            return "0";
        }
    }
    // to deslike a comment
    private static String updateDeslikeComment(String commentInfo) {
        try {
            if(DataBaseManager.UP_DisLike_Comment(commentInfo)) {
                //If the changes are applied successfully, return 1
                return "1";
            }
            return "0";
        }catch (Exception e){
            //if wasn't successfully, return 0
            return "0";
        }
    }
    //To edit channel name
    private static String editChannelName(String channelInfo) {
        try {
            String[] info=channelInfo.split("#",2);
            if(DataBaseManager.UP_Name_Chanel(info[0],info[1])) {
                //If the changes are applied successfully, return 1
                return "1";
            }
            return "0";
        }catch (Exception e){
            //if wasn't successfully, return 0
            return "0";
        }
    }

    private static class ErrorResponse {
        private String message;

        public ErrorResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
