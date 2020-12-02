import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 项 目 名 称：spring_security_management
 * 类 名 称：EncodingTest
 * 类 描 述：TODO
 * 创建时间：2020/11/30 9:36 PM
 * 创 建 人：huanghao
 *
 * @version: V1.8
 */
public class EncodingTest {

    /**
     * Md5加盐加密: 加密过来的一致
     *
     * Spring-Security 加盐加密: 随机盐加密位置是固定.加盐加密统一都是不一样形式
     *
     * @param args
     */
    public static void main(String[] args) {
        //$2a$10$q6T6rN8ohVgTUmZ2iZ87.eszIzJ83Tpu/wVcPNlRZ.Uq9NgsA9GHu
        //$2a$10$vYt7In5fVYGhsEBpepmReetmpDi568nnx8rUqQrKvTyeXP7Yde6ou
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("123"));
    }
}
