package io.simpolor.testing.service;

import io.simpolor.testing.domain.Demo;
import io.simpolor.testing.repository.DemoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class DemoService {

	private DemoRepository demoRepository;
	public DemoService(@Autowired DemoRepository demoRepository){
		this.demoRepository = demoRepository;
	}

	public long totalcount() {
		return demoRepository.count();
	}

	public List<Demo> list() {
		return demoRepository.findAll();
	}

	public Demo view(long seq) {
		return demoRepository.findById(seq).orElse(new Demo());
	}

	public Demo write(Demo demo) {
		return demoRepository.save(demo);
	}

	public Demo modify(Demo demo) {
		if(demoRepository.findById(demo.getSeq()).isPresent()){
			return demoRepository.save(demo);
		}
		return new Demo();
	}

	public long delete(long seq) {
		demoRepository.deleteById(seq);
		return seq;
	}


}
