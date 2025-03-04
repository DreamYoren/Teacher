package org.example.rain.Service.ServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.example.rain.Entity.Exam;
import org.example.rain.Mapper.ExamMapper;
import org.example.rain.Service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamMapper examMapper;

    @Override
    public void createExam(Exam exam) {
        examMapper.insert(exam);
    }

    @Override
    public void updateExam(Exam exam) {
        examMapper.updateById(exam);
    }

    @Override
    public void deleteExam(Long id) {
        examMapper.deleteById(id);
    }

    @Override
    public Exam getExamById(Long id) {
        return examMapper.selectById(id);
    }
}
