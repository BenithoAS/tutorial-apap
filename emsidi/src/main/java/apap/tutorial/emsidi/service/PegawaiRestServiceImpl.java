package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.repository.PegawaiDb;
import apap.tutorial.emsidi.rest.CabangDetail;
import apap.tutorial.emsidi.rest.PegawaiDetail;
import apap.tutorial.emsidi.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.*;

@Service
@Transactional
public class PegawaiRestServiceImpl implements PegawaiRestService{
    private final WebClient webClient;

    @Autowired
    private PegawaiDb pegawaiDb;

    @Override
    public PegawaiModel createPegawai(PegawaiModel pegawai) {
        return pegawaiDb.save(pegawai);
    }

    @Override
    public List<PegawaiModel> retrieveListPegawai() {
        return pegawaiDb.findAll();
    }

    @Override
    public PegawaiModel getPegawaiByNoPegawai(Long noPegawai) {
        Optional<PegawaiModel> pegawai = pegawaiDb.findByNoPegawai(noPegawai);

        if (pegawai.isPresent()) {
            return pegawai.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public PegawaiModel updatePegawai(Long noPegawai, PegawaiModel pegawaiUpdate) {
        PegawaiModel pegawai = getPegawaiByNoPegawai(noPegawai);
        pegawai.setNamaPegawai(pegawaiUpdate.getNamaPegawai());
        pegawai.setJenisKelamin(pegawaiUpdate.getJenisKelamin());

        return pegawaiDb.save(pegawai);
    }

    @Override
    public void deletePegawai(Long noPegawai) {
        LocalTime now = LocalTime.now();
        PegawaiModel pegawai = getPegawaiByNoPegawai(noPegawai);
        CabangModel cabang = pegawai.getCabang();

        if((now.isBefore(cabang.getWaktuBuka()) || now.isAfter(cabang.getWaktuTutup()))){
            pegawaiDb.delete(pegawai);

        } else {
            throw new UnsupportedOperationException();
        }
    }

    public PegawaiRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.pegawaiUrl).build();
    }

    @Override
    public Mono<PegawaiDetail> getUmur(Long noPegawai) {
        Map<String,Object> data = new HashMap<String,Object>();
        LocalTime now = LocalTime.now();
        PegawaiModel pegawai = getPegawaiByNoPegawai(noPegawai);
        String namaPegawai = pegawai.getNamaPegawai();
        CabangModel cabang = pegawai.getCabang();
        if((now.isBefore(cabang.getWaktuBuka()) || now.isAfter(cabang.getWaktuTutup()))){
            data.put("namaPegawai", pegawai.getNamaPegawai().charAt(0));
            return this.webClient.post().uri("/pegawai/umur/" + namaPegawai).syncBody(data).retrieve().bodyToMono(PegawaiDetail.class);
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
