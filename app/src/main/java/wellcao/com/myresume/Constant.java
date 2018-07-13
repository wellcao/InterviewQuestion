package wellcao.com.myresume;

/**
 * Created by hhc on 2017/12/10 0010.
 * email: haochafeiming@gmail.com
 * mobile: 132****3466
 */

public interface Constant {
    String Scheme="file://";
    String HeadPath="/myresume/head.jpg";


    String ERROR="error";
    String SUCCESS="success";
    String Js="javascript:";
    int PageSize=5;    //分页大小
    int MathID=1,ChineseID=2,EnglishID=3,ClassicID=4;

    /*******************************************
     *
     *              资源文件地址
     *
     ******************************************/
    String AssetUrl="file:///android_asset";
    // String AssetUrl="http://mstatic.canenglish.com";
    //   String AssetUrl="file:///data/data/com.xuezong.android/files";
    String ProjectIntroUrl=AssetUrl+"/vuefile/lesson_introduce/index_new_intro.html";  // 个人简介
    String CourseIntroductionUrl=AssetUrl+"/vuefile/lesson_introduce/index_new.html";  // 工作经历
    String ProjectExperUrl=AssetUrl+"/vuefile/lesson_introduce/index_new_exp.html";  //   项目经验
    String ProjectEducationUrl=AssetUrl+"/vuefile/lesson_introduce/index_new_education.html";  //教育背景
    String ProjectHobbiesUrl=AssetUrl+"/vuefile/lesson_introduce/index_new_hobbies.html";//  兴趣爱好

    /*******************************************

    /*******************************************
     *
     *              数据请求格式
     *
     ******************************************/

    String CLIENT_TYPE = "clientType=2&version=3.2.2";


    String CacheDirName="/cache";

    String ClientType="android_clent";

    int ClientTypeAndroid=2;

    String Prefix="Bearer";

    /*******************************************
     *
     *              JS请求类型
     *
     ******************************************/

    int FROM_ANDROID=2;


    /*******************************************
     *
     *              文件存储
     *
     ******************************************/
    String PdfUrl="https://yqall02.baidupcs.com/file/ea7b658f0590be4c3f0a3834ef0c8edf?bkt=p3-1400ea7b658f0590be4c3f0a3834ef0c8edfe51e6d37000000027f39&fid=4065255540-250528-1067772744095976&time=1513904439&sign=FDTAXGERLQBHSK-DCb740ccc5511e5e8fedcff06b081203-0gtjvwb7ALMAvvvtUciYV3srKi0%3D&to=73&size=163641&sta_dx=163641&sta_cs=2&sta_ft=docx&sta_ct=1&sta_mt=1&fm2=MH,Yangquan,Anywhere,,beijing,cnc&vuk=4065255540&iv=0&newver=1&newfm=1&secfm=1&flow_ver=3&pkey=1400ea7b658f0590be4c3f0a3834ef0c8edfe51e6d37000000027f39&sl=83034191&expires=8h&rt=sh&r=959724900&mlogid=8242160122149139148&vbdid=3920963079&fin=%E6%9B%B9%E6%80%80%E8%B1%AA%E7%AE%80%E5%8E%86.docx&fn=%E6%9B%B9%E6%80%80%E8%B1%AA%E7%AE%80%E5%8E%86.docx&rtype=1&dp-logid=8242160122149139148&dp-callid=0.1.1&hps=1&tsl=300&csl=300&csign=qJJ%2BafMJwINHLEPAjPNU%2FWPhY6Q%3D&so=0&ut=6&uter=4&serv=0&uc=1876143442&ic=3928773093&ti=617efd03bde799ad8572e5b6701af4cc8439c942fa17e7c2&by=themis";

    /*******************************************
     *
     *            数据库属性相关
     *
     ******************************************/
    int Choice_Single=0,Choice_Multi=1,FillBlank=2,True_False=3,Other=4;
}
