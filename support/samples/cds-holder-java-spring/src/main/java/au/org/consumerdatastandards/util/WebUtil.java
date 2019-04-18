package au.org.consumerdatastandards.util;

import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

public class WebUtil {

    final static String V = "x-v";
    final static String MIN_V = "x-min-v";
    final static String CORRELATION_ID = "x-Correlation-Id";
    final static String FAPI_INTERACTION_ID = "x-fapi-interaction-id";

    public static String getPaginatedLink(NativeWebRequest request, Integer page, Integer pageSize) {
        HttpServletRequest servletRequest = request.getNativeRequest(HttpServletRequest.class);
        String paginatedLink = getOriginalUrl(servletRequest);
        String originalPage = servletRequest.getParameter("page");
        if (StringUtils.isEmpty(originalPage)) {
            String pageParam = servletRequest.getParameterMap().isEmpty() ? "?page=" : "&page=";
            paginatedLink = paginatedLink + pageParam + page;
        } else {
            paginatedLink = paginatedLink.replace("page=" + originalPage, "page=" + page);
        }
        String originalPageSize = servletRequest.getParameter("page-size");
        if (StringUtils.isEmpty(originalPageSize)) {
            paginatedLink = paginatedLink + "&page-size=" + pageSize;
        } else {
            paginatedLink = paginatedLink.replace("page-size=" + originalPageSize, "page-size=" + pageSize);
        }
        return paginatedLink;
    }

    public static String getOriginalUrl(NativeWebRequest request) {
        return getOriginalUrl(request.getNativeRequest(HttpServletRequest.class));
    }

    public static HttpHeaders processHeaders(NativeWebRequest request) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(V, "" + getCurrentVersion());
        String correlationId = request.getHeader(CORRELATION_ID);
        if (!StringUtils.isEmpty(correlationId)) {
            responseHeaders.set(CORRELATION_ID, correlationId);
        }
        String fapiInteractionId = request.getHeader(FAPI_INTERACTION_ID);
        if (!StringUtils.isEmpty(fapiInteractionId)) {
            responseHeaders.set(FAPI_INTERACTION_ID, fapiInteractionId);
        } else {
            responseHeaders.set(FAPI_INTERACTION_ID, UUID.randomUUID().toString());
        }
        return responseHeaders;
    }

    private static String getOriginalUrl(HttpServletRequest request) {
        StringBuilder requestURL = new StringBuilder(request.getRequestURL().toString());
        String queryString = request.getQueryString();

        if (queryString == null) {
            return requestURL.toString();
        } else {
            return requestURL.append('?').append(queryString).toString();
        }
    }

    private static Integer getCurrentVersion() {
        return 1;
    }

    public static boolean hasSupportedVersion(NativeWebRequest request) {
        Integer maxVersion = null;
        String xv = request.getHeader(V);
        if(!StringUtils.isEmpty(xv)) {
            try {
                maxVersion = Integer.parseInt(xv);
            } catch (NumberFormatException e) {
                // ignore it
            }
        }
        Integer minVersion = null;
        String minv = request.getHeader(MIN_V);
        if(!StringUtils.isEmpty(minv)) {
            try {
                minVersion = Integer.parseInt(minv);
            } catch (NumberFormatException e) {
                // ignore it
            }
        }
        Integer currentVersion = getCurrentVersion();
        if (maxVersion != null && currentVersion > maxVersion) {
            return false;
        }
        return minVersion == null || currentVersion >= minVersion;
    }
}
