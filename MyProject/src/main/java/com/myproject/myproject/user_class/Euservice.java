package com.myproject.myproject.user_class;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.myproject.edu_class.UserClass;
import com.myproject.myproject.edu_user.User;

@Service
public class Euservice {

	@Autowired
	private EuMapper eumapper;
	
	// 학번 조회
	// 학번은 url을 통해 넘겨받았음
	// -> 필요없다.
	
	// 과목 조회
	// 과목 추가에 쓰기위해
	public List<UserClass> selectClass() {
		
		List<UserClass> classlist = null;		
		classlist = eumapper.selectClass();		
		return classlist;		
	}
		
	// 과목코드, 학번 삽입
	public String insertUser(Eu eu, User user, UserClass userclass) {
		
		System.out.println("아래부터 서비스단 작업물");
		int indexnum = eu.getIndexNum();
		int num = userclass.getNum();
		String classNumber = user.getClassNumber();
		double grade = userclass.getUserGrade();
		
		System.out.println("인덱스 :"+indexnum);
		System.out.println("과목코드 :"+num);
		System.out.println("학번 :"+classNumber);
		System.out.println("성적 :"+grade);
		
		int rows = eumapper.insertdb(indexnum, classNumber, num, grade);
		
		if(rows > 0) {
			return "추가 성공";
		}else {
			return "추가 실패";
		}
	}
	
	// 과목 중복 검사
	public int classChk(String classNumber, int num) {
		return eumapper.ClassChk(classNumber, num);
	}

	// 조회에 사용
	public List<Eu> getUserClass(String num) {
		List<Eu> eulist = eumapper.showClassByNum(num);
		return eulist;
	}
	
	// 조회에 사용
	public List<UserClass> getClassName(String num){
		List<UserClass> classList = eumapper.selectClassName(num);
		return classList;
	}
		
	
	// 수정 및 삭제에 사용
	public List<Eu> getEu(int num, String number) {
		
		return eumapper.selectEuByNum(num, number);
	}
	
	// 수정 및 삭제에 사용
	public Eu getNum(int num, String number) {
		
		return eumapper.selectByNum(num, number);
	}
		
	// 과목 성적을 수정하는 로직
	public String updateClass(Eu eu) {
		
		int row = eumapper.updateClass(eu);
		
		if(row > 0) {
			return "수정 성공";
		}else {
			return "수정 실패";
		}
	}
	
	// ★컨트롤러에서 파라미터는 일치해야 작동.. 서비스에서는 일치하지 않아도 된다★
	// 과목을 삭제하는 로직
	public String deleteClass(int numb, String classN) {
		int row = eumapper.deleteClass(numb, classN);
		
		if(row > 0) {
			return "삭제 성공";
		}else {
			return "삭제 실패";
		}
		
	}
		
	// 결과 조회
	public Map<String,String> result(String num) {
		List<Eu> eu = eumapper.showClassByNum(num);
		
		int job_it = 0;		// IT 개수
	    double job_it_score = 0;	// IT 점수
	    
		int job_data = 0;	// 데이터처리 개수	
	    double job_data_score = 0;	// 데이터처리 점수
	    
		int job_iac = 0;	// 정보통신 개수
	    double job_iac_score = 0;	// 정보통신 점수
		
		int size = eu.size();
		//System.out.println("사이즈: "+size);
		//System.out.println("ex1: "+eu.get(0).getNum());
		//System.out.println("ex1: "+eu.get(0).getUserGrade());
		
		for(int i=0; i<size; i++) {
			// 개수, 평균
		    if(eu.get(i).getNum() == 12) {
		    	// 파이썬 프로그래밍
		    	job_it += 1;
		    	job_it_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 13) {
		    	// 데이터 구조
		    	job_data += 1;
		    	job_data_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 14) {
		    	// 자바프로그래밍
		    	job_it += 1;
		    	job_it_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 15) {
		    	// 기계학습개론
		    	job_data += 1;
		    	job_data_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 16) {
		    	// 기계학습응용
		    	job_data += 1;
		    	job_data_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 17) {
		    	// 데이터마이닝 및 시각화
		    	job_data += 1;
		    	job_data_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 18) {
		    	// 데이터베이스
		    	job_data += 1;
		    	job_data_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 19) {
		    	// 알고리즘
		    	job_it += 1;
		    	job_it_score += Double.valueOf(eu.get(i).getUserGrade());
		    	job_data += 1;
		    	job_data_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 20) {
		    	// 빅데이터분석
		    	job_data += 1;
		    	job_data_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 21) {
		    	// 사물인터넷기초
		    	job_iac += 1;
		    	job_iac_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 22) {
		    	// 회로이론
		    	job_iac += 1;
		    	job_iac_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 23) {
		    	// 컴퓨터네트워크
		    	job_iac += 1;
		    	job_iac_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 24) {
		    	// 전자회로
		    	job_iac += 1;
		    	job_iac_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 25) {
		    	// 마이크로프로세서
		    	job_iac += 1;
		    	job_iac_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 26) {
		    	// 전자기학
		    	job_iac += 1;
		    	job_iac_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 27) {
		    	// 임베디드시스템
		    	job_iac += 1;
		    	job_iac_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 28) {
		    	// 컴퓨터구조
		    	job_iac += 1;
		    	job_iac_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 29) {
		    	// 통신이론
		    	job_iac += 1;
		    	job_iac_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 30) {
		    	// 확률 및 랜덤프로세스
		    	job_iac += 1;
		    	job_iac_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 31) {
		    	// 센서기반 사물인터넷
		    	job_iac += 1;
		    	job_iac_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 32) {
		    	// IoT보안
		    	job_it += 1;
		    	job_it_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 33) {
		    	// 디지털통신
		    	job_iac += 1;
		    	job_iac_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 34) {
		    	// 통신네트워크
		    	job_iac += 1;
		    	job_iac_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 35) {
		    	// 모바일 프로그래밍
		    	job_it += 1;
		    	job_it_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 36) {
		    	// 차세대이동통신
		    	job_iac += 1;
		    	job_iac_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 37) {
		    	// 초고속광네트워크
		    	job_iac += 1;
		    	job_iac_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 38) {
		    	// 사물인터넷SoC
		    	job_iac += 1;
		    	job_iac_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 39) {
		    	// 무선네트워크
		    	job_iac += 1;
		    	job_iac_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 40) {
		    	// 정보통신응용프로그래밍
		    	job_it += 1;
		    	job_it_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 41) {
		    	// 디지털논리회로
		    	job_iac += 1;
		    	job_iac_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 42) {
		    	// 정보보안
		    	job_it += 1;
		    	job_it_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 43) {
		    	// 신호 및 시스템
		    	job_iac += 1;
		    	job_iac_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 43) {
		    	// IT신기술세미나1
		    	job_it += 1;
		    	job_it_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 45) {
		    	// IT신기술세미나2
		    	job_it += 1;
		    	job_it_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 46) {
		    	// 디지털신호처리
		    	job_iac += 1;
		    	job_iac_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 47) {
		    	// 캡스톤디자인1
		    	job_it += 1;
		    	job_it_score += Double.valueOf(eu.get(i).getUserGrade());
		    	job_data += 1;
		    	job_data_score += Double.valueOf(eu.get(i).getUserGrade());
		    	job_iac += 1;
		    	job_iac_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 48) {
		    	// 캡스톤디자인2
		    	job_it += 1;
		    	job_it_score += Double.valueOf(eu.get(i).getUserGrade());
		    	job_data += 1;
		    	job_data_score += Double.valueOf(eu.get(i).getUserGrade());
		    	job_iac += 1;
		    	job_iac_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 49) {
		    	// 인터넷프로그래밍
		    	job_it += 1;
		    	job_it_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 50) {
		    	// ICT창업
		    	job_it += 1;
		    	job_it_score += Double.valueOf(eu.get(i).getUserGrade());
		    	job_data += 1;
		    	job_data_score += Double.valueOf(eu.get(i).getUserGrade());
		    	job_iac += 1;
		    	job_iac_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 51) {
		    	// 영상처리
		    	job_iac += 1;
		    	job_iac_score += Double.valueOf(eu.get(i).getUserGrade());
		    }else if(eu.get(i).getNum() == 52) {
		    	// 산학협력
		    	job_it += 1;
		    	job_it_score += Double.valueOf(eu.get(i).getUserGrade());
		    	job_data += 1;
		    	job_data_score += Double.valueOf(eu.get(i).getUserGrade());
		    	job_iac += 1;
		    	job_iac_score += Double.valueOf(eu.get(i).getUserGrade());
		    }
		}
	    
		double it_avg = (job_it_score / job_it);		// IT 평균
		double data_avg = (job_data_score / job_data);	// 데이터처리 평균
		double iac_avg = (job_iac_score / job_iac);	    // 정보통신 평균
		
		System.out.println("IT 개수: "+job_it);
		System.out.println("데이터 개수: "+job_data);
		System.out.println("정보통신 개수: "+job_iac);
		
	    System.out.println("IT 평균: "+it_avg);
		System.out.println("데이터 평균: "+data_avg);
		System.out.println("정보통신 평균: "+iac_avg);
	   
	    // 결과
	    String recommend = null;	
	    String top_txt = null;	
	    String kind = null;		
	    String job_list1 = null;
	    String job_list2 = null;	
	    String job_list3 = null;	
	    String job_list4 = null;	
	    String job_list5 = null;	
	    String job_ability1 = null;
	    String job_ability2 = null;
	    String job_ability3 = null;
	    String job_ability4 = null;
	    String job_ability5 = null;
	    
	    if (it_avg >= data_avg && it_avg >= iac_avg) {
            recommend = "IT전문인력";
            top_txt = "당신은 코딩의 신...?";
            kind = "IT";
            job_list1 = "UX 및 UI 전문가 : UX/UI 전문가는 와이어 프레임 및 모형을 스케치하고, 사용자에 대한 테스트를 거쳐 사용자의 인터페이스를 완성시켜줍니다.";
            job_list2 = "풀스택 개발자 : 웹 개발에 있어 만능 플레이어로 프트웨어 개발과 관련 다양한 지식을 갖고, 관련된 개념들을 제품에 적용해 구현시키는 직업입니다.";
            job_list3 = "파이썬 / 자바 개발자 : 파이썬과 자바는 간결하고 기능 구현이 용이한 언어이며, 해당 언어로 프로그램을 개발하는 개발자를 의미합니다.";
            job_list4 = "보안 프로그램 개발자 : 다양한 해킹방법을 인터넷을 이용하여 조사·연구한다. 보안을 점검할 수 있는 도구로서 시스템의 보안 상태를 점검하기 위한 시험도구(test tool)를 개발합니다.";
            job_list5 = "컴퓨터 바이러스 치료사 (컴퓨터 바이러스 기술자) : 디버그(debug) 같은 바이러스 분석 툴(tool)을 이용하여 메모리 감염 방법 등 컴퓨터 바이러스가 가지고 있는 특징을 분석하고 기존 백신 프로그램에 컴퓨터 바이러스를 치료하기 위한 데이터를 추가합니다.";
            job_ability1 = "UX 및 UI 전문가 : 정보통신응용프로그래밍과 파이썬 프로그래밍, 자바 프로그래밍을 필요로 합니다.";
            job_ability2 = "풀스택 개발자 : 인터넷 프로그래밍과 모바일 프로그래밍을 필요로합니다.";
            job_ability3 = "파이썬 / 자바 개발자 : 파이썬 프로그래밍과 자바 프로그래밍을 필요로합니다.";
            job_ability4 = "보안 프로그램 개발자 : 정보보안, 알고리즘과 iot 보안기술을 필요로합니다.";
            job_ability5 = "컴퓨터바이러스치료사(컴퓨터바이러스기술자) : 알고리즘 기술을 필요로합니다.";
	    }else if (data_avg >= it_avg && data_avg >= iac_avg) {
            recommend = "데이터전문인력";
            top_txt = "어떤 데이터든지 분석해낸다!";
            kind = "DATA";
            job_list1 = "데이터 아키텍트 : 현행 데이터 관리 기술을 식별하고 평가하며, 업계 요구사항을 해결하는 데이터 전략을 수립합니다.";
            job_list2 = "데이터 엔지니어 : DB를 이용하여 프로그래밍을 하는 직무로, JavaScript, SQL, Linux, Oracle, Hadoop, C++, Ruby, Phyton 등 다양한 프로그래밍 언어를 활용하여 빅데이터 처리합니다.";
			job_list3 = "데이터 비주얼라이저 : 분석 결과 스토리텔링, 분석 정보 시각화, 분석 정보 시각표현 및, 인터페이스 디자인, 사용자경험(UX) 디자인, 시각디자인에 대한 이해가 필요합니다.";
			job_list4 = "프로덕트 매니저 : Oracle, Netezza, Business Objects and Hyperion w ETL, Agile Software Development 개발과 Python, R, Java, Ruby, SQL 등의 프로그래밍 언어에 대한 지식이 필요합니다.";
			job_list5 = "데이터 과학자 : 사람들의 행동 패턴 또는 시장의 경제 상황 등을 예측하며 데이터 속에 함축된 트렌드나 인사이트를 도출하고 이로부터 새로운   부가 가치를 창출하기 위해 대량의 빅데이터를 관리하고 분석합니다.";
            job_ability1 = "데이터 아키텍트 : Hadoop과 같은 기술을 이용하여 빅데이터 솔루션을 제공하는 역량이 필요합니다.";
            job_ability2 = "데이터 엔지니어 : 빅데이터 솔루션 아키텍트가 설계한 것을 구축하고 빅데이터 솔루션의 개발, 유지관리, 테스트, 평가 역량이 필요합니다.";
            job_ability3 = "데이터 비주얼라이저 : 데이터를 시각화하여 조직 또는 상사가 이해하기 쉽게 변환하는 역량이 필요합니다.";
            job_ability4 = "프로덕트 매니저 : 필요한 분석과 데이터 정의 및 분석체계의 구체화를 계획하고, 데이터 분석의 결과를 조직의 상급 관리자에게 설명하는 능력이 필요합니다.";
            job_ability5 = "데이터 과학자 : 데이터 기술로 다양한 분야에서 새로운 비즈니스 또는 제품의 개발 기회 발굴 및 예산과 기획을 포함하는 프로젝트 관리 및 자문 능력이 필요합니다.";
	    }else if (iac_avg >= it_avg && iac_avg >= data_avg) {
            recommend = "정보통신전문인력";
            top_txt = "내 손으로 기가지니를!?";
            kind = "IAC";
            job_list1 = "통신기기기술자 : 제품 생산에 대한 정보를 입수하고 확인하며, 새로운 모델을 제작하기 위한 부품의 종류 및 사양, 제품 명세서등을 작성하고, 회로도를 작성합니다.";
            job_list2 = "사물인터넷 데이터 분석가 : 사물인터넷(Iot) 인프라를 담당하는 기술자와 협업을 하는 직업으로, 사물 인터넷이 생성하는 데이터를 분석하고 엮어 의미있는 정보로 가공합니다.";
            job_list3 = "Iot 개발 기술자 : 인터넷으로 사물간의 대화를 가능하게 하는 기술 개발전문이 주 분야이자, 네트워크를 통해 원거리에서도 정보를 교류 할 수 있도록 데이터를 주고 받는 기술환경을 개발합니다.";
            job_list4 = "이동통신 서비스설계자 : 이동통신 서비스를 제공하기 위한 이동통신시스템, 무선망, 부가서비스망 및 네트워크 보안부문에 대한 기본설계를 하며, 정보처리 및 정보관리에 대한 지식적이해가 필요합니다.";
            job_list5 = "인공지능 전문가 : 사람의 뇌 구조에 대한 지식을 바탕으로 컴퓨터나 로봇 등이 인간과 같이 생각하고 결정을 내릴 수 있도록 알고리즘을 개발하는 일을 하고 번역,상품 추천, 법률, 웨어러블 등 여러 분야의 비지니스에 관련된 직업입니다.";
            job_ability1 = "통신기기기술자 : 전자회로, 전자기학, 회로이론, 디지털논리회로 등의 지식을 필요로 합니다.";
            job_ability2 = "사물인터넷 데이터 분석가 : 사물인터넷 SoC과 임베디드 기술을 필요로 합니다.";
            job_ability3 = "Iot 개발 기술자 : 센서기반 사물인터넷과 사물인터넷 기초 기술을 필요로 합니다.";
            job_ability4 = "이동통신 서비스설계자 : 차세대 이통통신과 신호 및 시스템, 통신 네트워크 및 초고주파 통신 기술을 필요로 합니다.";
            job_ability5 = "인공지능 전문가 : 알고리즘과 확률 및 랜덤프로세스 기술을 필요로합니다.";
		
	    }
	    
	    Map<String,String> map= new HashMap<String, String>();
	    map.put("recommend", recommend);
	    map.put("top_txt", top_txt);
	    map.put("kind", kind);
	    map.put("job_list[1]", job_list1);
	    map.put("job_list[2]", job_list2);
	    map.put("job_list[3]", job_list3);
	    map.put("job_list[4]", job_list4);
	    map.put("job_list[5]", job_list5);
	    map.put("job_ability[1]", job_ability1);
	    map.put("job_ability[2]", job_ability2);
	    map.put("job_ability[3]", job_ability3);
	    map.put("job_ability[4]", job_ability4);
	    map.put("job_ability[5]", job_ability5);
	    
	    return map;
	}
	
	
	
	
}
