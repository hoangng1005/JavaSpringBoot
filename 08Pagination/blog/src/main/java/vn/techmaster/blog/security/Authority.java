package vn.techmaster.blog.security;

public class Authority {
    public static final String READ = "READ";  //Đọc được
    public static final String CREATE = "CREATE";
    public static final String DELETE = "DELETE";
    public static final String EDIT = "EDIT";
    public static final String COMMENT = "COMMENT";
    private Authority() {}
}
