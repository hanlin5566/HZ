package com.hzcf.operation.interceptor;

import java.io.Serializable;

import org.springframework.util.StringUtils;

/**
 * Create by hanlin on 2017年12月7日
 **/
public class AuthToken implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String[] keys = { "ad4e4db6269c0980b005c3aa15f8ecb8", "27f09d236f26457c9bf2980ca1876b18" };

	private static final TokenEncryption encryption = new TokenEncryption(keys);
	private static final String SEPARATOR = ",";

	public final long userId;
	public final long active;
	public final long expiry;

	/**
	 * 
	 * @param userId
	 * @param active
	 *            when the token is active (in milliseconds)
	 * @param expiry
	 *            when the token is expired (in milliseconds)
	 */
	public AuthToken(long userId, long expiry) {
		this.userId = userId;
		this.active = System.currentTimeMillis();
		this.expiry = this.active + expiry;
	}

	public AuthToken(long userId, long active, long expiry) {
		this.userId = userId;
		this.active = active;
		this.expiry = this.active + expiry;
	}

	/**
	 * Create a new token based on the time when being invoked.
	 * 
	 * @return encrypted string
	 * @throws EncryptException
	 */
	public String token() throws Exception {
		return encryption.encrypt(toString());
	}

	@Override
	public String toString() {
		return new StringBuilder().append(this.userId).append(SEPARATOR).append(this.active).append(SEPARATOR)
				.append(this.expiry).toString();
	}

	public boolean isActive() {
		long now = System.currentTimeMillis();
		if (userId == 0) {
			return false;
		}
		return now > active && now < expiry;
	}

	public static AuthToken parse(String token) throws Exception {
		String decrypt = encryption.decrypt(token);
		if (StringUtils.isEmpty(decrypt)) {
			return null;
		}

		String[] arr = decrypt.split(SEPARATOR);
		if (arr != null && arr.length == 3) {
			long userId = Long.valueOf(arr[0]);
			long active = Long.valueOf(arr[1]);
			long expiry = Long.valueOf(arr[2]);

			return new AuthToken(userId, active, expiry);
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		AuthToken token = AuthToken.parse("Laz3sQy+zDq/2O1/NRFXyqEVXPX5hsUrNSVJznyqFmygqsW8h/3G3Zmr05xUxFtnxOI3jEdzEK4jN+ziTakwhHUbXgxyrVrZOs8FsTR6ckw2/iJnT5vBYJo6pHMKs4m+H/Vkp1+Uv/4==");
		System.out.println(token);
	}
}
