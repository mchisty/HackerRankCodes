package org.siteminder;

/**
 * The Enum EmailPropEnum.
 */
public enum HttpResponseEnum {

	/** The code 200. */
	CODE_200(200),
	/** The code 201. */
	CODE_201(201),
	/** The code 202. */
	CODE_202(202),
	/** The code 401. */
	CODE_401(401),
	/** The code 400. */
	CODE_400(400);

	/** The c. */
	int c;

	/**
	 * Instantiates a new http response enum.
	 *
	 * @param code the code
	 */
	private HttpResponseEnum(int code) {
		this.c = code;
	}

	/**
	 * Gets the c.
	 *
	 * @return the c
	 */
	public int getCode() {
		return c;
	}


}
