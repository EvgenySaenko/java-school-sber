package ru.sber.javaschool.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sber.javaschool.entity.Urls;
import ru.sber.javaschool.repositories.DownloadRepository;
import ru.sber.javaschool.utils.DownloadFile;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DownloadService {
    private final DownloadRepository downloadRepository;
    private final DownloadFile downloadFile;

    //todo тут просто пока накидал грубо по синхронизации не думал еще(столкнулся с ошибкой закачки картинок или музыки)
    public List<Urls> uploadFiles(List<Long> urlsId){
        List<Urls> ringtones = this.downloadRepository.getListUrlById(urlsId);//получили список рингтонов для скачивания
        ExecutorService service = Executors.newFixedThreadPool(3);
        for(Urls urls: ringtones){
            service.execute(()->{
                downloadFile.upload(urls.getLink(),urls.getTitle());
            });
        }
        service.shutdown();
        return ringtones;
    }

    public Collection<Urls> getUrls(){
        return this.downloadRepository.getUrls();
    }

    public List<Urls> getSelected(List<Long> urlsId ){
        return this.downloadRepository.getListUrlById(urlsId);
    }

}
