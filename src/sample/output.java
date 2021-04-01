package sample;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import user.User;

public class output {

	public static void main(String[] args) {
		
		// インスタンスからJSONデータ作成
		// ユーザクラス
		User user = new User();
		user.setId("ID1234");
		user.setName("aiueo");
		user.setAge(30);
		
		// JSON変換用クラス
		ObjectMapper mapper1 = new ObjectMapper();
		
		try {
			// JSON文字列の変換
			String json = mapper1.writeValueAsString(user);
			System.out.println("①：" + json);
		} catch(JsonProcessingException e) {
			e.printStackTrace();
		}
		
		// JSONファイルの読み込み
		// 定義
		ObjectMapper mapper2 = new ObjectMapper();
		String currentPath = System.getProperty("user.dir");
		String path = currentPath + File.separator + "resource"+ File.separator + "sample.json";
		
		String[] keys = {"id", "name", "age"};
		try {
			JsonNode node = mapper2.readTree(new File(path));
			for(String key : keys) {
				String value = node.get(key).asText();
				System.out.println("②" + key + "：" + value);
			}
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
