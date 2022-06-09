package abuteen.hashem.ordermanagementbackend.service.impl;

import abuteen.hashem.ordermanagementbackend.dto.ProductDto;
import abuteen.hashem.ordermanagementbackend.dto.StockDto;
import abuteen.hashem.ordermanagementbackend.entity.Product;
import abuteen.hashem.ordermanagementbackend.entity.Stock;
import abuteen.hashem.ordermanagementbackend.exception.ChangeStockProductException;
import abuteen.hashem.ordermanagementbackend.exception.NotFoundException;
import abuteen.hashem.ordermanagementbackend.repository.ProductRepository;
import abuteen.hashem.ordermanagementbackend.repository.StockRepository;
import abuteen.hashem.ordermanagementbackend.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static abuteen.hashem.ordermanagementbackend.service.impl.ProductServiceImpl.mapToProductDto;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    StockRepository stockRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public StockDto createStock(StockDto stockDto) {
        int id = stockDto.getProductDto().getId();
        if(!productRepository.existsById(id)){
            throw new NotFoundException();
        }
        Stock stock = new Stock();
        stock.setProduct(productRepository.getReferenceById(id));
        stock.setQuantity(stock.getQuantity());
        stock.setUpdatedAt(new Date());
        stockRepository.save(stock);
        stockDto.setProductDto(mapToProductDto(stock.getProduct()));
        stockDto.setId(stock.getId());
        stockDto.setUpdatedAt(stock.getUpdatedAt());
        return stockDto;
    }

    @Override
    public void deleteStock(int id) {
        if(!stockRepository.existsById(id)){
            throw new NotFoundException();
        }
        stockRepository.delete(stockRepository.getReferenceById(id));
    }

    @Override
    public List<StockDto> getAll() {
        List<Stock> stockList = stockRepository.findAll();
        List<StockDto> stockDtoList = new LinkedList<>();
        for(Stock stock : stockList){
            stockDtoList.add(mapToStockDto(stock));
        }
        return stockDtoList;
    }

    private StockDto mapToStockDto(Stock stock) {
        StockDto stockDto = new StockDto();
        stockDto.setProductDto(mapToProductDto(stock.getProduct()));
        stockDto.setQuantity(stock.getQuantity());
        stockDto.setId(stock.getId());
        stockDto.setUpdatedAt(stock.getUpdatedAt());
        return stockDto;
    }

    @Override
    public StockDto getByID(int id) {
        if(!stockRepository.existsById(id)){
            throw new NotFoundException();
        }
        return mapToStockDto(stockRepository.getReferenceById(id));
    }

    @Override
    public StockDto update(StockDto stockDto) {
        if(!stockRepository.existsById(stockDto.getId())){
            throw new NotFoundException();
        }
        if(stockDto.getProductDto()!=null&&!productRepository.existsById(stockDto.getProductDto().getId())){
            throw new NotFoundException();
        }
        Stock stock = stockRepository.getReferenceById(stockDto.getId());
        if(stockDto.getProductDto()!=null&&stock.getProduct().getId()!= stockDto.getProductDto().getId()){
            throw new ChangeStockProductException();
        }
        stock.setQuantity(stockDto.getQuantity());
        stock.setUpdatedAt(new Date());
        stockRepository.save(stock);
        stockDto.setUpdatedAt(stock.getUpdatedAt());
        stockDto.setProductDto(mapToProductDto(stock.getProduct()));
        return stockDto;
    }
}
