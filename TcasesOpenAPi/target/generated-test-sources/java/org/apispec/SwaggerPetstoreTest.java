package org.apispec;


import org.cornutum.tcases.openapi.test.ResponseValidator;

import org.junit.Test;

import java.util.Map;
import static java.util.stream.Collectors.toMap;

import io.restassured.http.Header;
import io.restassured.response.Response;

import org.hamcrest.Matcher;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SwaggerPetstoreTest {

    private ResponseValidator responseValidator = new ResponseValidator( getClass());

    @Test
    public void getPets_TagsDefined_Is_Yes() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .queryParam( "limit", "-176843958")
                .queryParam( "tags", "")
            .when()
                .request( "GET", "/pets")
            .then()
                .statusCode( isSuccess())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void getPets_TagsDefined_Is_No() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
            .when()
                .request( "GET", "/pets")
            .then()
                .statusCode( isSuccess())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void getPets_TagsItemsSize_Is_1() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .queryParam( "limit", "0")
                .queryParam( "tags", "eb6yVxsAu58,U`yOd7l(dL[!\\qu>roGn%6Q/qBv_G.Fc67[f?~?|Ab@[Zu4P$/t'\\~Wd 07SKYGV|x@o-iA-V:iC%<bx8IH8Nkqy(h4;/+]+<^$MQEN%!4[C7FNN|ov5gQNRE3Dv\"Bk\"3q8[uMpGe\\1rN)j8/%R}s^w.=HBP~d5eZbC=:-4`jHsu#f?>Jyr%S-%a\"DO(5&O{NHfux")
            .when()
                .request( "GET", "/pets")
            .then()
                .statusCode( isSuccess())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void getPets_TagsItemsSize_Is_Gt_1() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .queryParam( "tags", "")
                .queryParam( "tags", "+^&)KUBGO-K[s I={+>Pr|Qd@EDY&Tzx0i37i?8*l' \\l o,GNa{G;XNZkmiuVTw.vUt$$5ySJ$~J#&Z.-an\"MADRg#\"E`%$>JA.I@_xH|0'A")
                .queryParam( "tags", "9CVvWb|bd!v?BPydr!Nm|4<fqy\"_>J]u7luIj4z2}}XXM^Fr3~gTb}{Ml@HZV?|l]/|7S3EPGsJtK1GpTHh^{wGq4*14*ZX=*Kz7Fq5^)O90Q]H[j+7f,(f-E<HnV'g$x#N(EW01s5{U$rvHfu)vjCQ:^f>Jac VSdV.|8YrF58PX76")
                .queryParam( "tags", "@LT,3ha2@>a0M!|C{'~5Qv%]H1rc~h\\I:G(pr{iV\"6%LGA6:pvE\"eS(56lCBek2G(v8AV!7Q\"*Q<<K,YB}!)Un~\\'L56(bCQ~B=6&)J]i~Ny5d9Mm~wq1ti\\(0W+_4', G|W&hG|y")
                .queryParam( "tags", "{u&k\\%,k\"")
            .when()
                .request( "GET", "/pets")
            .then()
                .statusCode( isSuccess())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void getPets_TagsItemsUnique_Is_No() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .queryParam( "limit", "1064777276")
                .queryParam( "tags", "s(rARuuj#jiSZTcwP>cLo>}~As n].c3J%hv`DMA][juj2\\:|@\\V")
                .queryParam( "tags", "Rs.@")
                .queryParam( "tags", "|\\Z4tf!)rRQ<8@=T?t3+=t\"H[Y20DtBQ%\"4?q;{#E_pCw(#IXy#.$r(rli!3{RzeLsG21)Dr)$>Mi7gYi.Qs35Iz:>Nvf`zR`c-V,tJ_}%mrk$h[=|'64m-YcO_N+)pcn2c>8iZ'#GdK^0mHwifyga@^fHt[L9M?<w:Wt?$l&Ye2fFSAuTh|OJe\\h[1f5M{&[Qfx;Gk4{yqPWKI :F&yDbCPv\\:>@U]__m,.[&TLk,.")
                .queryParam( "tags", "{}\"y.4Q@Bb#gQBba5sB4(I{rR'of-Wv}G~b\\t,}yDTL,-2\"*U0s\\\"UiHBvnAp2;BaPw$P*F&9h;2f-R+,hE{,cm0JtmdJ`N->Qp'")
                .queryParam( "tags", "HiRM|%LOy&6@BK{!-deR&{&7r@;>><I><i!}t^}gL-(XChIN&JQV9|H(0XQzxBoc$D\"!+'odf2VSvL[Z")
                .queryParam( "tags", "?T_g|{gqF0J\"5@/{X ed7~720q7\"?or?$7)+@e")
                .queryParam( "tags", "{Z;.*[\";AU*$8Z++1V(yuHfHW*lxkZn$i:")
                .queryParam( "tags", "TbJ}d1W^VeiPM//7m9JwVKW3-}j=k[%qQQt{'.84PyLxxP<KR3Zs_J\"lfUF")
                .queryParam( "tags", "O1h%jIWDcx{HH{lJ@!z{u,W\"-{S\"PJ%<'3Fu- ?`8i/{eW3cA_X@LWi58`jPP GH)mn`:B#8pG bZIg!Vl,wA3BDn>AJ@^L8du^<a_4K]f!?Q;9)WLzqc-C. wR7g^S3*tLUv)wTLv??")
                .queryParam( "tags", "+.~ 79iRz/ *@>n=..nFAVBeQP(+]Ss;*+tQbiWfumw~V(Sv2U@2c90zy]J~YZ8!='_ecQ|,V;*q1#o")
                .queryParam( "tags", "TbJ}d1W^VeiPM//7m9JwVKW3-}j=k[%qQQt{'.84PyLxxP<KR3Zs_J\"lfUF")
                .queryParam( "tags", "ijjj%BGp+#%hD9{gd6gwF$zM2 6g^]l}t03")
                .queryParam( "tags", "M-N#H-;L?2#jAt 'El<A<-OAZRPYU7<'5B9iBgB?+qQVlECtzc;G<<WNrUUc\\:sv/{A]ytW\\L>/X-;7&)XMBV1v*D8|cd;J_ &o9<M*wS\"Nw}OjQv]f\"!eZ}v6q'Sg%Z1E<%N")
                .queryParam( "tags", "Clg`FCigFUpr)nS/Urr9?DK?jj&rs'(o;.V&pD/`V9O{Mr(pG&NBrswX5zI")
            .when()
                .request( "GET", "/pets")
            .then()
                .statusCode( isSuccess())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void getPets_TagsType_Is_Null() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .queryParam( "tags", (String) null)
            .when()
                .request( "GET", "/pets")
            .then()
                // tags.Type=null
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void getPets_TagsType_Is_NotArray() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .queryParam( "tags", "true")
            .when()
                .request( "GET", "/pets")
            .then()
                // tags.Type=Not array
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void getPets_TagsItemsContainsType_Is_Null() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .queryParam( "tags", (String) null)
            .when()
                .request( "GET", "/pets")
            .then()
                // tags.Items.Contains.Type=null
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void getPets_LimitType_Is_Null() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .queryParam( "limit", (String) null)
            .when()
                .request( "GET", "/pets")
            .then()
                // limit.Type=null
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void getPets_LimitType_Is_NotInteger() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .queryParam( "limit", "631%PNl")
            .when()
                .request( "GET", "/pets")
            .then()
                // limit.Type=Not integer
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void postPets_BodyDefined_Is_Yes() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .contentType( "application/json")
                .request().body( "{\"name\":\"|>EiC]IUWa<PEsD7cf{+y1PU|iwV\\\\>eMHlc/YYQD.?|S:;7q0ca$w1*G16z#Mt:L)\\\"I+gM;W,95>\\\"'}IZN\\\\fzGKQ}fyl9\\\"Y-@x>XG35mI/),Pb0k%pJV^g*oI5:iHn87~'EtrMYMUNHb*ICKe'9^F=s$ JI+Nq2Bz~c%|YBHE6,RQnK+qV,!z|./o#NZvkB`AT:i[W7R{w{Uw|{\",\"tag\":\"0!X*=B\\\\fZGQ&6oe<!._$di51%PCpU:%1Hp0ix[gr/`-K)Kj:(Ihd\\\\uL{(wm>]/)E`o8z(.Slu;2-x6\\\\x[(Gr;l\\\\oV*G}m<>I;O/T_^I@h{Na$UA189uNNQDsj)\",\"sbyynkxllzyfr\":{\"jqradcgmcf\":-710,\"bj\":\"5\\\\rcpJ\",\"q\":-789},\"qsmhqbdxq\":{\"awibxzm\":\"US|$T_Y\",\"s\":422.4,\"ogm\":\"WbK.xZ\"}}")
            .when()
                .request( "POST", "/pets")
            .then()
                .statusCode( isSuccess())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "POST", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "POST", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void postPets_BodyApplicationJsonValuePropertiesNameValueLength_Is_0() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .contentType( "application/json")
                .request().body( "{\"name\":\"\"}")
            .when()
                .request( "POST", "/pets")
            .then()
                .statusCode( isSuccess())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "POST", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "POST", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void postPets_BodyApplicationJsonValuePropertiesTagValueLength_Is_0() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .contentType( "application/json")
                .request().body( "{\"name\":\"_`^Je]gA.$s2];,iEhz*WLRoR|DBx*X.i&uQJ>^KUl]8nf(8~ko/*3.oVsZQ^y3:y(BAeR-0n7PtWKoFjSE6g^_\\\"^*x/<)Mu0xTVz1*!*o>rB}\\\\|4^FD1{oomT;K+{(TI-%@|lQV`lJ8Fo ]aJI@LS K*$,@!F#s-YhN<(,GFkQO'<!tETDR,t@d^L314!\\\"y*H/Mv#4PKhr2'[cMM-X~cYS{1]v)6?03u\",\"tag\":\"\",\"veyuxzwdxfuloe\":398.5}")
            .when()
                .request( "POST", "/pets")
            .then()
                .statusCode( isSuccess())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "POST", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "POST", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void postPets_BodyDefined_Is_No() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
            .when()
                .request( "POST", "/pets")
            .then()
                // Body.Defined=No
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "POST", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "POST", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void postPets_BodyMediaType_Is_Other() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .contentType( "text/plain")
                .request().body( "[\"$ i\"]")
            .when()
                .request( "POST", "/pets")
            .then()
                // Body.Media-Type=Other
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "POST", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "POST", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void postPets_BodyApplicationJsonType_Is_Null() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .contentType( "application/json")
                .request().body( "null")
            .when()
                .request( "POST", "/pets")
            .then()
                // Body.application-json.Type=null
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "POST", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "POST", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void postPets_BodyApplicationJsonType_Is_NotObject() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .contentType( "application/json")
                .request().body( "true")
            .when()
                .request( "POST", "/pets")
            .then()
                // Body.application-json.Type=Not object
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "POST", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "POST", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void postPets_BodyApplicationJsonValuePropertiesNameDefined_Is_No() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .contentType( "application/json")
                .request().body( "{}")
            .when()
                .request( "POST", "/pets")
            .then()
                // Body.application-json.Value.Properties.name.Defined=No
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "POST", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "POST", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void postPets_BodyApplicationJsonValuePropertiesNameType_Is_Null() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .contentType( "application/json")
                .request().body( "{\"name\":null}")
            .when()
                .request( "POST", "/pets")
            .then()
                // Body.application-json.Value.Properties.name.Type=null
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "POST", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "POST", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void postPets_BodyApplicationJsonValuePropertiesNameType_Is_NotString() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .contentType( "application/json")
                .request().body( "{\"name\":510.3}")
            .when()
                .request( "POST", "/pets")
            .then()
                // Body.application-json.Value.Properties.name.Type=Not string
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "POST", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "POST", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void postPets_BodyApplicationJsonValuePropertiesTagType_Is_Null() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .contentType( "application/json")
                .request().body( "{\"name\":\"\",\"tag\":null}")
            .when()
                .request( "POST", "/pets")
            .then()
                // Body.application-json.Value.Properties.tag.Type=null
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "POST", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "POST", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void postPets_BodyApplicationJsonValuePropertiesTagType_Is_NotString() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .contentType( "application/json")
                .request().body( "{\"name\":\"\",\"tag\":[\"+P\"]}")
            .when()
                .request( "POST", "/pets")
            .then()
                // Body.application-json.Value.Properties.tag.Type=Not string
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "POST", "/pets", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "POST", "/pets", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void deletePetsId_IdDefined_Is_Yes() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .pathParam( "id", "-3591043632136692307")
            .when()
                .request( "DELETE", "/pets/{id}")
            .then()
                .statusCode( isSuccess())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "DELETE", "/pets/{id}", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "DELETE", "/pets/{id}", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void deletePetsId_IdValue_Is_0() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .pathParam( "id", "0")
            .when()
                .request( "DELETE", "/pets/{id}")
            .then()
                .statusCode( isSuccess())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "DELETE", "/pets/{id}", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "DELETE", "/pets/{id}", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void deletePetsId_IdValue_Is_Gt_0() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .pathParam( "id", "1730003345025772809")
            .when()
                .request( "DELETE", "/pets/{id}")
            .then()
                .statusCode( isSuccess())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "DELETE", "/pets/{id}", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "DELETE", "/pets/{id}", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void deletePetsId_IdType_Is_Null() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .pathParam( "id", "")
            .when()
                .request( "DELETE", "/pets/{id}")
            .then()
                // id.Type=null
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "DELETE", "/pets/{id}", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "DELETE", "/pets/{id}", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void deletePetsId_IdType_Is_NotInteger() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .pathParam( "id", "")
            .when()
                .request( "DELETE", "/pets/{id}")
            .then()
                // id.Type=Not integer
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "DELETE", "/pets/{id}", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "DELETE", "/pets/{id}", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void getPetsId_IdDefined_Is_Yes() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .pathParam( "id", "-750438969541726824")
            .when()
                .request( "GET", "/pets/{id}")
            .then()
                .statusCode( isSuccess())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets/{id}", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets/{id}", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void getPetsId_IdValue_Is_0() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .pathParam( "id", "0")
            .when()
                .request( "GET", "/pets/{id}")
            .then()
                .statusCode( isSuccess())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets/{id}", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets/{id}", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void getPetsId_IdValue_Is_Gt_0() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .pathParam( "id", "2117288314602917937")
            .when()
                .request( "GET", "/pets/{id}")
            .then()
                .statusCode( isSuccess())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets/{id}", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets/{id}", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void getPetsId_IdType_Is_Null() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .pathParam( "id", "")
            .when()
                .request( "GET", "/pets/{id}")
            .then()
                // id.Type=null
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets/{id}", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets/{id}", response.statusCode(), responseHeaders( response));
    }

    @Test
    public void getPetsId_IdType_Is_NotInteger() {
        Response response =
            given()
                .baseUri( forTestServer( "http://petstore.swagger.io/api"))
                .pathParam( "id", "w}+,@K,lA/``G@")
            .when()
                .request( "GET", "/pets/{id}")
            .then()
                // id.Type=Not integer
                .statusCode( isBadRequest())
            .extract()
                .response()
                ;

        responseValidator.assertBodyValid( "GET", "/pets/{id}", response.statusCode(), response.getContentType(), response.asString());
        responseValidator.assertHeadersValid( "GET", "/pets/{id}", response.statusCode(), responseHeaders( response));
    }

    private static Matcher<Integer> isSuccess() {
        return allOf( greaterThanOrEqualTo(200), lessThan(300));
    }

    private static Matcher<Integer> isBadRequest() {
        return allOf( greaterThanOrEqualTo(400), lessThan(500));
    }

    private static String forTestServer( String defaultUri) {
        String testServer = tcasesApiServer();
        return
            defaultUri == null || !testServer.isEmpty()
            ? testServer
            : defaultUri;
    }

    private static String tcasesApiServer() {
        String uri = System.getProperty( "tcasesApiServer");
        return uri == null? "" : uri.trim();
    }

    private static Map<String,String> responseHeaders( Response response) {
        return
            response.getHeaders().asList().stream()
            .collect( toMap( Header::getName, Header::getValue));
    }
}
