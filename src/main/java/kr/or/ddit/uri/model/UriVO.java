package kr.or.ddit.uri.model;

public class UriVO {
	private String uri;
	private String className;
	
	public UriVO() {

	}

	public UriVO(String uri, String className) {
		super();
		this.uri = uri;
		this.className = className;
	}

	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return "UriVO [uri=" + uri + ", className=" + className + "]";
	}
	
}
