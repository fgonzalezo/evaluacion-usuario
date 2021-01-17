package com.everis.cl.evaluacion.util;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static com.everis.cl.evaluacion.util.AppConstant.*;

public class Varios {
    public static void formatMessageException(
            final HttpServletResponse response, final int handlerStatus, final String handlerMeessage)
            throws IOException {

        String json = String.format(FORMAT_MESSAGE_JWT, handlerMeessage);
        response.setStatus(handlerStatus);
        response.setContentType(TYPE_MESSAGE_JWT);
        response.setCharacterEncoding(CHARACTER_ENCODING_MESSAGE_JWT);
        response.getWriter().write(json);
    }

    public static String dateNow() {
        return DateTimeFormatter.ofPattern(DATE_PATTERN)
                .withZone(ZoneOffset.UTC)
                .format(LocalDateTime.now());
    }

    public static String getStubs(final String name) {
        final Class variosClass = Varios.class;
        final InputStream inputStream = variosClass.getResourceAsStream(String.format("/pruebas/%s", name));

        return readFromInputStream(inputStream);
    }

    private static String readFromInputStream(final InputStream inputStream) {
        final StringBuilder resultStringBuilder = new StringBuilder();

        try (final BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }

        return resultStringBuilder.toString();
    }
}
