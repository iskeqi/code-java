package com.keqi.springbootmvcparam.filter;

/**
 * 认证过滤器(进行 accessToken 的鉴权)
 *
 *
 *  实际使用过程中，发现使用 Filter 来认证用户是否登录，并没有 Interceptor 方便，简直是差太远了
 * @author keqi
 */
/*@Order(1)
@Component
@WebFilter(urlPatterns = "/**")
public class AuthFilter implements Filter {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final List<String> excludePaths = new ArrayList<>();

    static {
        String[] knife4jPaths = new String[]{
                "/doc.html",
                "/webjars/**",
                "/swagger-resources/**",
                "/swagger-ui.html/**",
                "/v2/**",
                "/favicon.ico",
                "/error"
        };
        // 放行 knife4j 请求路径
        excludePaths.addAll(Arrays.asList(knife4jPaths));
        // 放行登录接口请求路径
        excludePaths.add("/sys/auth/login");
        // 放行公开文件请求路径
        excludePaths.add("/publicFile/**");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException {

        try {
            HttpServletRequest req = (HttpServletRequest) request;
            String servletPath = req.getServletPath() + "/";

            boolean isAuth = true;

            for (String t : excludePaths) {
                if (t.endsWith("/**")) {
                    t = t.substring(0, t.indexOf("/**") + 1);
                }
                if (servletPath.startsWith(t)) {
                    isAuth = false;
                    break;
                }
            }

            if (isAuth) {
                String accessToken = req.getHeader(CommonConstant.ACCESS_TOKEN);
                if (StrUtil.isBlank(accessToken)) {
                    throw new RuntimeException();
                }
                String accountInfo = (String) stringRedisTemplate.opsForHash().get(SysConstant.UUID_LOGIN_INFO, accessToken);
                if (StrUtil.isBlank(accountInfo)) {
                    throw new RuntimeException();
                }
                LoginUserBO loginUserBO = JsonUtil.readValue(accountInfo, LoginUserBO.class);
                // 设置当前操作用户信息到当前线程对象中
                Auth.setLoginUserBO(loginUserBO);
            }

            chain.doFilter(request, response);
            Auth.setLoginUserBO(null);
        } catch (Throwable e) {
            // 使用 response 手动的返回数据
            ResultEntity resultEntity = ResultEntityBuilder.noAuth();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.append(JsonUtil.writeValueAsString(resultEntity));
            writer.flush();
            writer.close();
        }
    }
}*/
