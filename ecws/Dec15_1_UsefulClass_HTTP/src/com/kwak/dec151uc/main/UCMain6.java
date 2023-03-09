package com.kwak.dec151uc.main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

//https://api.openweathermap.org/data/2.5/weather?q=seoul&appid=baff8f3c6cbc28a4024e336599de28c4(키값)&units=metric(섭씨)&lang=kr
//https://api.openweathermap.org/data/2.5/weather?q=seoul&appid={API key}

//데이터를 html 모양으로 표현: xml => xml parsing
//		-> 아니 어차피 자바스크립트에서 쓸 건데 왜 html 모양으로 ???
//								↓↓↓
//데이터를 자바스크립트 모양으로 표현: json(JavaScript Object Notation) => 현 시장 주력
//			Json 파일 저장 -> new -> 파일 -> 파일명.json
//	자바스크립트 -> 배열: 대괄호[] / 객체: 중괄호{멤버변수명: "", 멤버변수명: }
public class UCMain6 {
	public static void main(String[] args) {
		HttpsURLConnection huc = null;
		try {
			URL u = new URL(
					"https://api.openweathermap.org/data/2.5/weather?q=seoul&appid=baff8f3c6cbc28a4024e336599de28c4&units=metric&lang=kr");
			huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);

			JSONParser jp = new JSONParser();
//			{ 로 시작하는지 => 객체인지 -> JSONParser
//			[ 로 시작하는지	=> 배열인지 -> JSONObject

			JSONObject jo = (JSONObject) jp.parse(br.readLine()); // -> 데이터 전체 불러오기
//											jp.parse(isr); => 도 가능 -> 그러려면 bufferedReader 부터는 지워야함!
			JSONArray weather = (JSONArray) jo.get("weather"); // -> 원하는 객체 찾아오기 jo.get -> 그 객체가 배열로 시작하니깐 JSONArray
			JSONObject w = (JSONObject) weather.get(0); // ja[0] 같은거 -> ja 안에 객체가 들어있으므로 w 만들어주기
			System.out.println(w.get("description"));
			
			JSONObject main = (JSONObject) jo.get("main");
			System.out.println("현재 기온: "+main.get("temp"));
			System.out.println("체감 기온: "+main.get("feels_like"));
			System.out.println("습도: "+main.get("humidity"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();
	}
}
