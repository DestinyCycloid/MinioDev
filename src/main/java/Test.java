import io.minio.MinioClient;
import io.minio.errors.MinioException;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Test {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InvalidKeyException, XmlPullParserException {
        try {
            // Create a minioClient with the Minio Server name, Port, Access key and Secret key.
            MinioClient minioClient = new MinioClient("http://localhost:9000", "5YZPVYROOQZ2IULNX33V", "rio0wQsdxhDXaNjDqeolS9lgOeIQXdjjeUjbI3sl");

            // Check if the bucket already exists.
            boolean isExist = minioClient.bucketExists("test");
            if (isExist) {
                System.out.println("Bucket already exists.");
            } else {
                // Make a new bucket called asiatrip to hold a zip file of photos.
                minioClient.makeBucket("test");
            }

            // Upload the zip file to the bucket with putObject
            minioClient.putObject("test", "minio.exe", "D:\\minio\\minio.exe");
            System.out.println("successfully uploaded as minio.exe to `test` bucket.");
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
        }
    }
}

