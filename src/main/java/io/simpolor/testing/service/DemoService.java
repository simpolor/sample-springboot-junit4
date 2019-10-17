package io.simpolor.testing.service;

import io.simpolor.testing.domain.*;
import io.simpolor.testing.repository.DemoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Service
public class DemoService {

	@Autowired
	private ApplicationEventPublisher publisher;

	private DemoRepository demoRepository;
	public DemoService(@Autowired DemoRepository demoRepository){
		this.demoRepository = demoRepository;
	}

	private long visit;

	@PostConstruct
	public void DemoService(){
		this.visit = 10;
	}

	public void setVisit(long visit) {
		this.visit = visit;
	}

	public long getVisit() {
		return this.visit;
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

		publisher.publishEvent(DemoEvent.of(demo.getName(), demo.getAge(), DemoState.INSERT));

		return demoRepository.save(demo);
	}

	public Demo modify(Demo demo) {

		publisher.publishEvent(DemoEvent.of(demo.getName(), demo.getAge(), DemoState.UPDATE));
		if(demoRepository.findById(demo.getSeq()).isPresent()){
			return demoRepository.save(demo);
		}
		return new Demo();
	}

	public long delete(long seq) {

		Demo demo = demoRepository.findById(seq).get();
		if(demo != null){
			publisher.publishEvent(DemoEvent.of(demo.getName(), demo.getAge(), DemoState.DELETE));
			demoRepository.deleteById(seq);
		}

		return seq;
	}


}
