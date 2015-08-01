package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import modelos.Hierarquia;
import modelos.Pasta;
import modelos.Tag;

public class PastaDAO extends BasicDAO {
	public List<Hierarquia> buscarHierarquia() throws Exception{
		try{
			criarQuery("SELECT id, id_pasta_pai, nome FROM pasta");
			ResultSet res =  (ResultSet) ps.executeQuery();	
			List<Hierarquia> hierarquia = new ArrayList<Hierarquia>();
			while (res.next()){
				Hierarquia h = new Hierarquia();
				h.setId(res.getString("id"));
				h.setParent(res.getString("id_pasta_pai"));
				h.setText(res.getString("nome"));
				hierarquia.add(h);
			}
			return hierarquia;
		}
		catch(Exception e){
			throw e;
		}
	}

	public List<Pasta> buscarPastasFilhas(int idPasta)throws Exception{
		try{
			criarQuery("SELECT * FROM PASTA WHERE id_pasta_pai = ? AND id != ?");
			ps.setInt(1, idPasta);
			ps.setInt(2, idPasta);
			ResultSet res =  (ResultSet) ps.executeQuery();	
			List<Pasta> pastas = new ArrayList<Pasta>();
			while (res.next()){
				Pasta p = new Pasta();
				p.setId(res.getInt("id"));
				p.setNome(res.getString("nome"));
				p.setNumEstrela(res.getInt("num_estrela"));
				p.setImagem(res.getInt("id"));
				p.setPublica(res.getBoolean("publica"));
				p.setDescricao(res.getString("descricao"));
				p.setTags(buscarTags(p.getId()));
				pastas.add(p);
			}
			return pastas;
		}
		catch(Exception e){
			throw e;
		}
		finally{
			close();
		}
	}
	
	public List<Tag> buscarTags(int idPasta) throws Exception{
		try{
			setQuery("SELECT tag.id AS `id`, tag.nome AS `nome` FROM pasta LEFT JOIN pasta_tag ON (pasta.id = pasta_tag.id_pasta) 	LEFT JOIN tag ON (tag.id = pasta_tag.id_tag) WHERE pasta.id = ?");
			ps.setInt(1, idPasta);
			ResultSet res =  (ResultSet) ps.executeQuery();	
			res =  (ResultSet) ps.executeQuery();	
			List<Tag> tags = new ArrayList<Tag>();
			//if(res.next) n�o funciona... verificar o motivo disso...
			res.next();
			if(res.getString("nome") != null){
				do {
					Tag tag = new Tag();
					tag.setId(res.getInt("id"));
					tag.setNome(res.getString("nome"));
					tags.add(tag);
				} while (res.next());
			}
			else {
				tags = null;
			}
			
			return tags;
		}
		catch(Exception e){
			throw e;
		}
	}
	

	public Pasta adicionar(Pasta pasta)throws Exception{
		try{
			criarQuery("INSERT INTO pasta (`id_pasta_pai`,	`nome`,	`data_criacao`,	`num_estrela`,`publica`) VALUES (?,?,?,?,?)");
			ps.setInt(1, pasta.getPai());
			ps.setString(2, pasta.getNome());
			ps.setTimestamp(3, pasta.getDataCriacao());
			ps.setInt(4, pasta.getNumEstrela());
			ps.setBoolean(5, pasta.isPublica());
			//ps.setBytes(6, pasta.getImagem());
			ps.executeUpdate();
			ps = (PreparedStatement) c.prepareStatement("SELECT LAST_INSERT_ID() id FROM pasta");
			ResultSet res =  (ResultSet) ps.executeQuery();	
			res =  (ResultSet) ps.executeQuery();	
			if (res.next()){
				pasta.setId(res.getInt("id"));
			}
			return pasta;
		}
		catch(Exception e){
			throw e;
		}
		finally{
			close();
		}
	}
	
	public Pasta alterar(Pasta pasta)throws Exception{
		try{
			criarQuery("UPDATE pasta SET id_pasta_pai=?, nome = ?,	num_estrela= ?, publica = ? WHERE id = ?");
			ps.setInt(1, pasta.getPai());
			ps.setString(2, pasta.getNome());
			ps.setInt(3, pasta.getNumEstrela());
			ps.setBoolean(4, pasta.isPublica());
			//ps.setBytes(5, pasta.getImagem());
			ps.setInt(5, pasta.getId());
			ps.executeUpdate();
			return pasta;
		}
		catch(Exception e){
			throw e;
		}
		finally{
			close();
		}
	}

	public void remover(int idPasta)throws Exception{
		try{
			criarQuery("DELETE FROM pasta WHERE id=?");
			ps.setInt(1, idPasta);
			ps.executeUpdate();
		}
		catch(Exception e){
			throw e;
		}
		finally{
			close();
		}
	}
	
	public void atualizarImagem(byte[] img, int id) throws Exception{
		try{
			criarQuery("UPDATE pasta SET `imagem` = ? WHERE id = ?");
			ps.setBytes(1, img);
			ps.setInt(2, id);
			ps.executeUpdate();
		}
		catch(Exception e){
			throw e;
		}
		finally{
			close();
		}
	}

	public byte[] getImagem(int id) throws Exception{
		try{
			criarQuery("SELECT imagem FROM pasta WHERE id = ?");
			ps.setInt(1, id);
			ResultSet res =  (ResultSet) ps.executeQuery();	
			res =  (ResultSet) ps.executeQuery();
			res.next();
			return res.getBytes("imagem");
		}
		catch(Exception e){
			throw e;
		}
		finally{
			close();
		}
	}
}
