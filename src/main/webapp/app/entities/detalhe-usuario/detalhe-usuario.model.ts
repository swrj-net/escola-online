import { IHistoricoDebito } from 'app/entities/historico-debito/historico-debito.model';

export interface IDetalheUsuario {
  id?: number;
  cpf?: string | null;
  celular?: string | null;
  historicoDebitos?: IHistoricoDebito[] | null;
}

export class DetalheUsuario implements IDetalheUsuario {
  constructor(
    public id?: number,
    public cpf?: string | null,
    public celular?: string | null,
    public historicoDebitos?: IHistoricoDebito[] | null
  ) {}
}

export function getDetalheUsuarioIdentifier(detalheUsuario: IDetalheUsuario): number | undefined {
  return detalheUsuario.id;
}
